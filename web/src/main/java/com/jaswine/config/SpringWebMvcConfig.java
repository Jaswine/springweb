package com.jaswine.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * SpringMVC配置
 * @author Jaswine
 */
@Configuration
@EnableWebMvc
@EnableAsync
@ComponentScan("com.jaswine.controller")
public class SpringWebMvcConfig extends WebMvcConfigurerAdapter {


	/**
	 * 配置视图解析器
	 * @return 视图解析器
	 */
	@Bean
	public InternalResourceViewResolver setViewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/");

		return viewResolver;
	}

	/**
	 * 配置Json视图解析器
	 * @return json视图解析
	 */
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		List<MediaType> mediaTypes = new ArrayList<>();
		mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		converter.setSupportedMediaTypes(mediaTypes);

		converter.setObjectMapper(objectMapper());

		return converter;
	}

	private ObjectMapper objectMapper(){
		ObjectMapper objectMapper = new ObjectMapper();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		objectMapper.setDateFormat(dateFormat);

		return objectMapper;
	}

	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter(){
		return new StringHttpMessageConverter();
	}

	@Bean
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
		RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
		List<HttpMessageConverter<?>> httpMessageConverters = new ArrayList<>();

		httpMessageConverters.add(mappingJackson2HttpMessageConverter());
		httpMessageConverters.add(stringHttpMessageConverter());

		handlerAdapter.setMessageConverters(httpMessageConverters);

		return handlerAdapter;
	}


	/**
	 * 开启静态资源的处理
	 * @param configurer 配置
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * 欢迎页
	 * @param registry 注册
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index.html");
	}
}
