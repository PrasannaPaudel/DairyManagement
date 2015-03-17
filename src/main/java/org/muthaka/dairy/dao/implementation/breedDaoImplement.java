package org.muthaka.dairy.dao.implementation;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.muthaka.dairy.Models.Breeding;
import org.muthaka.dairy.dao.breedDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MUTHAKA on 2/20/2015.
 */
@Repository public class breedDaoImplement implements breedDao {

	private static final Logger logger = Logger.getLogger(breedDaoImplement.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override public void addBreed(Breeding breed) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.persist(breed);
			logger.info("Breed Saved SuccessFully, Breed Details=" + breed);
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			logger.error("Breed did not save" + ex);
			throw ex;
		}

	}

	@Override public void updateBreed(Breeding breed) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(breed);
			logger.info("Breed updated successfully, Feed Details=" + breed);
		} catch (RuntimeException ex) {
			logger.error("Breed Was not Updated" + ex);
			throw ex;
		}

	}

	@Override public List<Breeding> listBreed() {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Breeding> breedList = session.createQuery("from Breeding ").list();
			for (Breeding breed : breedList) {
				logger.info("Breed List::" + breed);
			}
			return breedList;
		} catch (RuntimeException ex) {
			logger.error("Feed list was not Loaded" + ex);
			throw ex;
		}
	}

	@Override public Breeding getBreedById(Integer breedId) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			Breeding breed = (Breeding)session.load(Breeding.class, breedId);
			logger.info("Breeds loaded successfully, Breeds Details=" + breed);
			return breed;
		} catch (RuntimeException ex) {
			logger.error("Breeds did not load" + ex);
			throw ex;
		}
	}

	@Override public void removeBreed(Integer breedId) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Breeding breed = (Breeding)session.load(Breeding.class, breedId);
			if (null != breed) {
				session.delete(breed);
			}
			logger.info("Cow deleted successfully, Cow Details=" + breed);
		} catch (RuntimeException ex) {
			throw ex;
		}
	}
}
