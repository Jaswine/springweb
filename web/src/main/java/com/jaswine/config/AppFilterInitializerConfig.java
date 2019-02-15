package com.jaswine.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;


/**
 * 配置Filter
 * @author Jaswine
 */
@Order(11)
@Slf4j
public class AppFilterInitializerConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		log.info("配置Filter");

		registerCORSFilter(servletContext);
		registerEncodingFilter(servletContext);
	}

	/**
	 * 配置跨域
	 * @param servletContext servlet上下文
	 */
	private void registerCORSFilter(ServletContext servletContext){

		CorsConfiguration configuration = new CorsConfiguration();

		configuration.addAllowedOrigin("*");
		configuration.addAllowedHeader("*");
		configuration.addAllowedMethod("*");
		configuration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**",configuration);

		FilterRegistration.Dynamic corsFilter = servletContext.addFilter("corsFilter", new CorsFilter(source));

		corsFilter.addMappingForUrlPatterns(null,false,"/*");
		corsFilter.setAsyncSupported(true);

		log.info("配置跨域");
	}


	/**
	 * 配置字符编码
	 * @param servletContext servlet上下文
	 */
	private void registerEncodingFilter(ServletContext servletContext){
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter("UTF-8", true);

		FilterRegistration.Dynamic registration = servletContext.addFilter("encodingFilter", encodingFilter);

		registration.addMappingForUrlPatterns(null,false,"/*");
		registration.setAsyncSupported(true);

		log.info("配置字符编码");
	}


}
