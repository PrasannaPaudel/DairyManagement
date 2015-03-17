package org.muthaka.dairy.dao.implementation;

/**
 * Created by MUTHAKA on 2/20/2015.
 */

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.muthaka.dairy.Models.MilkProduction;
import org.muthaka.dairy.dao.milkDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository public class milkDaoImplement implements milkDao {
	private static final Logger logger = Logger.getLogger(milkDaoImplement.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override public void addMilk(MilkProduction milkproduced) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.persist(milkproduced);
			logger.info("Milk Saved SuccessFully, Milk Details=" + milkproduced);
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			logger.error("Milk did not save" + ex);
			throw ex;
		}

	}

	@Override public void updateMilk(MilkProduction milkproduced) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(milkproduced);
			logger.info("Milk updated successfully, Milk Details=" + milkproduced);
		} catch (RuntimeException ex) {
			logger.error("Milk Was not Updated" + ex);
			throw ex;
		}

	}

	@Override public List<MilkProduction> listMilkProduced() {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<MilkProduction> milkList = session.createQuery("from MilkProduction ").list();
			for (MilkProduction milk : milkList) {
				logger.info("Milk List::" + milk);
			}
			return milkList;
		} catch (RuntimeException ex) {
			logger.error("Milk list was not Loaded" + ex);
			throw ex;
		}
	}

	@Override public MilkProduction getMilkById(Integer milkId) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			MilkProduction milk = (MilkProduction)session.load(MilkProduction.class, milkId);
			logger.info("Milk loaded successfully, Milk Details=" + milk);
			return milk;
		} catch (RuntimeException ex) {
			logger.error("Milk did not load" + ex);
			throw ex;
		}
	}

	@Override public MilkProduction getMilkByUuid(Integer milkUuid) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			MilkProduction milk = (MilkProduction)session.load(MilkProduction.class, milkUuid);
			logger.info("Milk loaded successfully, Milk Details=" + milk);
			return milk;
		} catch (RuntimeException ex) {
			logger.error("Milk did not load" + ex);
			throw ex;
		}
	}

	@Override public void removeMilk(Integer milkId) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			MilkProduction milk = (MilkProduction)session.load(MilkProduction.class, milkId);
			if (null != milk) {
				session.delete(milk);
			}
			logger.info("Milk Information deleted successfully, Milk Details=" + milk);
		} catch (RuntimeException ex) {
			throw ex;
		}
	}
}
