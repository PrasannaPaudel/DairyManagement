package org.muthaka.dairy.dao.implementation;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.muthaka.dairy.Models.Health;
import org.muthaka.dairy.dao.healthDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
@Repository public class healthDaoImplement implements healthDao {
    private static final Logger logger = Logger.getLogger(healthDaoImplement.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override public void addHealth(Health Health) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.persist(Health);
            logger.info("Health Saved SuccessFully, Health Details=" + Health);
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            logger.error("Health did not save" + ex);
            throw ex;
        }

    }

    @Override
    public void updateHealth(Health Health) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.update(Health);
            logger.info("Health updated successfully, Health Details=" + Health);
        } catch (RuntimeException ex) {
            logger.error("Health Was not Updated" + ex);
            throw ex;
        }

    }

    @Override
    public List<Health> listHealth() {

        Session session = this.sessionFactory.getCurrentSession();
        try {
            List<Health> healthList = session.createQuery("from Health ").list();
            for (Health h : healthList) {
                logger.info("Health List::" + h);
            }
            return healthList;
        } catch (RuntimeException ex) {
            logger.error("Health list was not Loaded" + ex);
            throw ex;
        }
    }

    @Override
    public Health getHealthById(Integer healthId) {

        Session session = this.sessionFactory.getCurrentSession();
        try {
            Health h = (Health)session.load(Health.class, healthId);
            logger.info("Health loaded successfully, Health Details=" + h);
            return h;
        } catch (RuntimeException ex) {
            logger.error("Health did not load" + ex);
            throw ex;
        }
    }



    @Override public void removeHealth(Integer healthId) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            Health Health = (Health)session.load(Health.class, healthId);
            if (null != Health) {
                session.delete(Health);
            }
            logger.info("Health Detail deleted successfully, Health Details=" + Health);
        } catch (RuntimeException ex) {
            throw ex;
        }
    }
}
