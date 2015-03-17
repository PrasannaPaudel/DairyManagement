package org.muthaka.dairy.dao.implementation;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.muthaka.dairy.Generators.UuidGen;
import org.muthaka.dairy.Models.Users;
import org.muthaka.dairy.dao.usersDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MUTHAKA on 3/6/2015.
 */
@Repository public class UsersDaoImplement implements usersDao {

	private static final Logger logger = Logger.getLogger(UsersDaoImplement.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override public void addUser(Users user) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			String uuid = new UuidGen().uuidGen();
			user.setUserUuid(uuid);
			session.persist(user);
			logger.info("Staff Saved SuccessFully, Staff Details=" + user);
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			logger.error("Cow did not Staff" + ex);
			throw ex;
		}

	}

	@Override public void updateUser(Users user) {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(user);
			logger.info("Cow updated successfully, Cow Details=" + user);
		} catch (RuntimeException ex) {
			logger.error("Cow Was not Updated" + ex);
			throw ex;
		}

	}

	@Override public List<Users> listUser() {

		Session session = this.sessionFactory.getCurrentSession();
		try {
			List<Users> userList = session.createQuery("from Users ").list();
			for (Users us : userList) {
				logger.info("User List::" + us);
			}
			return userList;
		} catch (RuntimeException ex) {
			logger.error("User list was not Loaded" + ex);
			throw ex;
		}
	}

	@Override public Users getUserById(Integer UserId) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Users us = (Users)session.load(Users.class, UserId);
			logger.info("Cow loaded successfully, Feeds Details=" + us);
			return us;
		} catch (RuntimeException ex) {
			logger.error("Feeds did not load" + ex);
			throw ex;
		}
	}

	@Override public Users getUserByUuid(String UserUuid) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Users us = (Users)session.load(Users.class, UserUuid);
			logger.info("Users loaded successfully, Users Details=" + us);
			return us;
		} catch (RuntimeException ex) {
			logger.error("Feeds did not load" + ex);
			throw ex;
		}
	}

	@Override public void removeUser(Users user) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			Users us = (Users)session.load(Users.class, user);
			if (null != us) {
				session.delete(us);
			}
			logger.info("Cow deleted successfully, Cow Details=" + us);
		} catch (RuntimeException ex) {
			throw ex;
		}
	}
}
