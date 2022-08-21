package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.demo.Test;
import com.example.demo.Testaspect;

@EnableAspectJAutoProxy
@Configuration
public class Aspectconfig {

	@Bean
	public Test test() {
		return new Test();
	}
	
	@Bean
	public Testaspect testaspect() {
		return new Testaspect();
	}
}
