package com.ivk23.lms.service.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.ivk23.lms.aop.aspects.DbMethodCallsAspect;
import com.ivk23.lms.aop.aspects.ServicesMethodCallsAspect;
import com.ivk23.lms.dao.configs.DaoSpringConfigs;

@Configuration
@ComponentScan(basePackages = { "com.ivk23.lms.service", "com.ivk23.lms.aop.aspects" })
@Import(value = { DaoSpringConfigs.class})
@EnableAspectJAutoProxy
public class ServiceSpringConfigs {
	
	@Bean
	public ServicesMethodCallsAspect sma() {
		return new ServicesMethodCallsAspect();
	}
	
	@Bean
	public DbMethodCallsAspect dma() {
		return new DbMethodCallsAspect();
	}
	
}
