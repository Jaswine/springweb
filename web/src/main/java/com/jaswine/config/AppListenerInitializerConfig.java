package com.jaswine.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.web.Log4jServletContextListener;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 配置Listerner
 * @author Jaswine
 */
@Order(12)
@Slf4j
public class AppListenerInitializerConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		log.info("配置Listener");
		registerLogListener(servletContext);
	}

	/**
	 * 日志监听
	 * @param servletContext servlet上下文
	 */
	private void registerLogListener(ServletContext servletContext){

		servletContext.setInitParameter("logConfiguration","classpath:log4j2.xml");
		servletContext.addListener(Log4jServletContextListener.class);

		log.info("配置日志监听");
	}
}
