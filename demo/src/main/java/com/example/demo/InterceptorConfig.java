package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
@Component
@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	DemoInterceptor Interceptor;

	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(Interceptor);
	}

	/*
	 * @Override public void configureViewResolvers(ViewResolverRegistry registry) {
	 * InternalResourceViewResolver viewresolver= new
	 * InternalResourceViewResolver(); viewresolver.setSuffix(".jsp");
	 * viewresolver.setPrefix("/WEB-INF/jsp/");
	 * viewresolver.setViewClass(JstlView.class);
	 * registry.viewResolver(viewresolver); }
	 */
}
