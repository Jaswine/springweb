package com.jaswine.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 应用启动配置类
 * <p>
 *    使用Servlet3规范中
 *    相当于原来的web.xml文件
 * </p>
 * @author Jaswine
 */
@Order(10)
@Slf4j
public class AppServletInitializerConfig implements WebApplicationInitializer {

	/**
	 * 初始化Servlet容器
	 * @param servletContext Servlet容器上下文
	 * @throws ServletException servlet异常
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

	}

}
