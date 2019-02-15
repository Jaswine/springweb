package com.jaswine.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 配置DispatcherServlet
 * @author Jaswine
 */
@Order(30)
@Slf4j
public class DispatcherServletInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 指定Spring配置主类
	 * @return 配置
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		log.info("配置Spring配置主类");
		return new Class<?>[]{
				SpringConfig.class
		};
	}

	/**
	 * 指定MVC配置类
	 * @return 配置
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		log.info("配置Spring其他配置类");
		return new Class<?>[]{
				SpringWebMvcConfig.class
		};
	}

	/**
	 * 映射DispatcherServlet到'/'上
	 * @return 映射
	 */
	@Override
	protected String[] getServletMappings() {
		log.info("配置DispatcherServlet的映射");
		return new String[]{"/"};
	}
}
