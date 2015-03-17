package org.muthaka.dairy.Listener;

import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;

/**
 * Created by MUTHAKA on 1/28/2015.
 */
public class Log4jContextListener implements ServletContextListener {

	/**
	 * Initialize log4j when the application is being started
	 */
	@Override public void contextInitialized(ServletContextEvent event) {
		// initialize log4j here
		ServletContext context = event.getServletContext();
		String log4jConfigFile = context.getInitParameter("log4j-config-location");
		String fullPath = context.getRealPath("") + File.separator + log4jConfigFile;
		PropertyConfigurator.configure(fullPath);
	}

	@Override public void contextDestroyed(ServletContextEvent event) {
		// do nothing
	}
}
