package org.han.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.han.dao.Mp3DAOImpl;
import org.han.service.Mp3Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class mListener
 *
 */
@WebListener
public class mListener implements ServletContextListener {

	private static Logger logger = LoggerFactory.getLogger("mListener");

	/**
	 * Default constructor.
	 */
	public mListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// 서버가 죽을 때 실행되는 메소드
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent event) {
		// 서버가 실행 될때 자동으로 실행되는 메소드

		ServletContext ctx = event.getServletContext();

		logger.info("logger..." );
		
		Mp3Service service = new Mp3Service();
		service.setDao(new Mp3DAOImpl());

		ctx.setAttribute("Mp3service", service);
		


	}

}
