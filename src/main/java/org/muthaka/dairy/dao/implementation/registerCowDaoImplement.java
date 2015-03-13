package org.muthaka.dairy.dao.implementation;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.muthaka.dairy.Models.CowRegistration;
import org.muthaka.dairy.dao.registerCowDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MUTHAKA on 2/24/2015.
 */
@Repository public class registerCowDaoImplement implements registerCowDao {


        private static final Logger logger = Logger.getLogger(registerCowDaoImplement.class);

        private SessionFactory sessionFactory;

        public void setSessionFactory(SessionFactory sf) {
            this.sessionFactory = sf;
        }

    @Override public void addCow(CowRegistration cowReg) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.persist(cowReg);
            logger.info("Cow Saved SuccessFully, Cow Details=" + cowReg);
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            logger.error("Cow did not save" + ex);
            throw ex;
        }


    }

    @Override
    public void updateCow(CowRegistration cowReg) {

        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.update(cowReg);
            logger.info("Cow updated successfully, Cow Details=" + cowReg);
        } catch (RuntimeException ex) {
            logger.error("Cow Was not Updated" + ex);
            throw ex;
        }

    }




    @SuppressWarnings("unchecked") @Override public List<CowRegistration> listCowReg() {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            List<CowRegistration> cowList = session.createQuery("from CowRegistration").list();
            for (CowRegistration cow : cowList) {
                logger.info("Cow List::" + cow);
            }
            return cowList;
        } catch (RuntimeException ex) {
            logger.error("Cow list was not Loaded" + ex);
            throw ex;
        }
    }





    @Override
    public CowRegistration getCowById(Integer cowId) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            CowRegistration cow = (CowRegistration)session.load(CowRegistration.class, cowId);
            logger.info("Cow loaded successfully, Feeds Details=" + cow);
            return cow;
        } catch (RuntimeException ex) {
            logger.error("Feeds did not load" + ex);
            throw ex;
        }
    }

    @Override
    public CowRegistration getCowByUuid(Integer cowUuid) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            CowRegistration cow = (CowRegistration)session.load(CowRegistration.class, cowUuid);
            logger.info("Cow loaded successfully, Cow Details=" + cow);
            return cow;
        } catch (RuntimeException ex) {
            logger.error("Feeds did not load" + ex);
            throw ex;
        }
    }

    @Override public void removeCow(Integer cowId) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            CowRegistration cow = (CowRegistration)session.load(CowRegistration.class, cowId);
            if (null != cow) {
                session.delete(cow);
            }
            logger.info("Cow deleted successfully, Cow Details=" + cow);
        } catch (RuntimeException ex) {
            throw ex;
        }
    }


}
