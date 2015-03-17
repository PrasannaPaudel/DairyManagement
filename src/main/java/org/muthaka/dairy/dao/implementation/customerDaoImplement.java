package org.muthaka.dairy.dao.implementation;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.muthaka.dairy.Models.Customers;
import org.muthaka.dairy.dao.customerDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
@Repository public class customerDaoImplement implements customerDao {

	private static final Logger logger = Logger.getLogger(customerDaoImplement.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override public void addCustomer(Customers customer) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.persist(customer);
			logger.info("Customer Saved SuccessFully, Customer Details=" + customer);
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			logger.error("Customer did not save" + ex);
			throw ex;
		}

	}

	@Override public void updateCustomer(Customers customer) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(customer);
			logger.info("Customer updated successfully, Customer Details=" + customer);
		} catch (RuntimeException ex) {
			logger.error("Customer Was not Updated" + ex);
			throw ex;
		}

	}

	@Override public List<Customers> listCustomer() {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Customers> customersList = session.createQuery("from Customers ").list();
			for (Customers cut : customersList) {
				logger.info("Customer List::" + cut);
			}
			return customersList;
		} catch (RuntimeException ex) {
			logger.error("Customer list was not Loaded" + ex);
			throw ex;
		}
	}

	@Override public Customers getCustomerById(Integer customerId) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Customers cut = (Customers)session.load(Customers.class, customerId);
			logger.info("Feeds loaded successfully, Feeds Details=" + cut);
			return cut;
		} catch (RuntimeException ex) {
			logger.error("Feeds did not load" + ex);
			throw ex;
		}
	}

	@Override public void removeCustomer(Integer customerId) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Customers customer = (Customers)session.load(Customers.class, customerId);
			if (null != customer) {
				session.delete(customer);
			}
			logger.info("Customer deleted successfully, Customer Details=" + customer);
		} catch (RuntimeException ex) {
			throw ex;
		}
	}
}
