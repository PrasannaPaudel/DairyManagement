package org.muthaka.dairy.Listener;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.URL;

/**
 * Created by MUTHAKA on 1/28/2015.
 */
public class HibernateServletContextListener implements ServletContextListener {
    @Override public void contextDestroyed(ServletContextEvent sce) {
        SessionFactory sf = (SessionFactory)sce.getServletContext().getAttribute("SessionFactory");
        sf.close();
    }

    @Override public void contextInitialized(ServletContextEvent sce) {
        URL url = HibernateServletContextListener.class.getResource("/hibernate.cfg.xml");
        Configuration config = new Configuration();
        config.configure(url);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf = config.buildSessionFactory(serviceRegistry);
        sce.getServletContext().setAttribute("SessionFactory", sf);

    }





}
