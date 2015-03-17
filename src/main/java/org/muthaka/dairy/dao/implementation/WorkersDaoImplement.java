package org.muthaka.dairy.dao.implementation;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.muthaka.dairy.Models.Workers;
import org.muthaka.dairy.dao.workersDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
@Repository public class WorkersDaoImplement implements workersDao {
	private static final Logger logger = Logger.getLogger(WorkersDaoImplement.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override public void addWorker(Workers worker) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.persist(worker);
			logger.info("Worker Saved SuccessFully, Worker Details=" + worker);
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			logger.error("Worker was not saved" + ex);
			throw ex;
		}

	}

	@Override public void updateWorker(Workers worker) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(worker);
			logger.info("Worker updated successfully, Worker Details=" + worker);
		} catch (RuntimeException ex) {
			logger.error("Worker Was not Updated" + ex);
			throw ex;
		}

	}

	@Override public List<Workers> listWorker() {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Workers> workList = session.createQuery("from Workers ").list();
			for (Workers work : workList) {
				logger.info("Workers List::" + work);
			}
			return workList;
		} catch (RuntimeException ex) {
			logger.error("Workers list was not Loaded" + ex);
			throw ex;
		}
	}

	@Override public Workers getWorkerById(Integer workerId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Workers w = (Workers)session.load(Workers.class, workerId);
			logger.info("Workers loaded successfully, Workers Details=" + w);
			return w;
		} catch (RuntimeException ex) {
			logger.error("Worker did not load" + ex);
			throw ex;
		}
	}

	@Override public Workers getWorkerByUuid(Integer workerUuid) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Workers w = (Workers)session.load(Workers.class, workerUuid);
			logger.info("Workers loaded successfully, Workers Details=" + w);
			return w;
		} catch (RuntimeException ex) {
			logger.error("Worker did not load" + ex);
			throw ex;
		}
	}

	@Override public void removeWorker(Workers worker) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Workers work = (Workers)session.load(Workers.class, worker);
			if (null != work) {
				session.delete(work);
			}
			logger.info("Worker deleted successfully, Worker Details=" + work);
		} catch (RuntimeException ex) {
			throw ex;
		}
	}
}
