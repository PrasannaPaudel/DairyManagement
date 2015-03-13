package org.muthaka.dairy.dao.implementation;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.muthaka.dairy.Models.DairyFeeds;
import org.muthaka.dairy.dao.mealDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MUTHAKA on 2/20/2015.
 */
@Repository public class mealDaoImplement implements mealDao {
    private static final Logger logger = Logger.getLogger(mealDaoImplement.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addFeeds(DairyFeeds dairyfeeds) {

        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.persist(dairyfeeds);
            logger.info("Feed Saved SuccessFully, Feed Details=" + dairyfeeds);
        } catch (RuntimeException ex) {
            session.getTransaction().rollback();
            logger.error("Feed did not save" + ex);
            throw ex;
        }

    }

    @Override
    public void updateFeeds(DairyFeeds dairyfeeds) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.update(dairyfeeds);
            logger.info("Feed updated successfully, Feed Details=" + dairyfeeds);
        } catch (RuntimeException ex) {
            logger.error("Feed Was not Updated" + ex);
            throw ex;
        }

    }

    @Override
    public List<DairyFeeds> listDairyFeeds() {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            List<DairyFeeds> dairyList = session.createQuery("from DairyFeeds ").list();
            for (DairyFeeds feed : dairyList) {
                logger.info("Feed List::" + feed);
            }
            return dairyList;
        } catch (RuntimeException ex) {
            logger.error("Feed list was not Loaded" + ex);
            throw ex;
        }
    }

    @Override
    public DairyFeeds getFeedsById(Integer dairyId) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            DairyFeeds feeds = (DairyFeeds)session.load(DairyFeeds.class, dairyId);
            logger.info("Feeds loaded successfully, Feeds Details=" + feeds);
            return feeds;
        } catch (RuntimeException ex) {
            logger.error("Feeds did not load" + ex);
            throw ex;
        }
    }
    @Override public void removeFeed(Integer dairyId) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            DairyFeeds feed = (DairyFeeds)session.load(DairyFeeds.class, dairyId);
            if (null != feed) {
                session.delete(feed);
            }
            logger.info("Feed deleted successfully, Feed Details=" + feed);
        } catch (RuntimeException ex) {
            throw ex;
        }
    }
}
