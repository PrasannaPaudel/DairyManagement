package org.muthaka.dairy.dao.implementation;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.muthaka.dairy.Models.MilkSold;
import org.muthaka.dairy.dao.milkSoldDao;

import java.util.List;

/**
 * Created by MUTHAKA on 3/10/2015.
 */
public class milkSoldDaoImplement implements milkSoldDao {

	private static final Logger logger = Logger.getLogger(milkSoldDaoImplement.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override public void addMilkSold(MilkSold sell) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.persist(sell);
			logger.info("Sell Saved SuccessFully, Cow Details=" + sell);
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			logger.error("Milk Sold did not save" + ex);
			throw ex;
		}

	}

	@Override public void updateMilkSold(MilkSold sell) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(sell);
			logger.info("Cow updated successfully, Cow Details=" + sell);
		} catch (RuntimeException ex) {
			logger.error("Cow Was not Updated" + ex);
			throw ex;
		}

	}

	@SuppressWarnings("unchecked") @Override public List<MilkSold> listMilkSold() {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<MilkSold> sellList = session.createQuery("from MilkSold ").list();
			for (MilkSold sell : sellList) {
				logger.info("Sold Milk List::" + sell);
			}
			return sellList;
		} catch (RuntimeException ex) {
			logger.error("Milk Sold list was not Loaded" + ex);
			throw ex;
		}
	}

	@Override public MilkSold getMilkSoldById(Integer sellId) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			MilkSold sell = (MilkSold)session.load(MilkSold.class, sellId);
			logger.info("Milk Sold loaded successfully, Milk Sold Details=" + sell);
			return sell;
		} catch (RuntimeException ex) {
			logger.error("Sold Milk did not load" + ex);
			throw ex;
		}
	}

	@Override public void removeMilkSold(Integer sellId) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			MilkSold sell = (MilkSold)session.load(MilkSold.class, sellId);
			if (null != sell) {
				session.delete(sell);
			}
			logger.info("Milk Sold deleted successfully, Milk Sold Details=" + sell);
		} catch (RuntimeException ex) {
			throw ex;
		}
	}

}
