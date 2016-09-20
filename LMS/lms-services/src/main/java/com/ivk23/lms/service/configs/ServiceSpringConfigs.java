package com.ivk23.lms.service.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.ivk23.lms.dao.configs.DaoSpringConfigs;

@Configuration
@ComponentScan(basePackages = { "com.ivk23.lms.service" })
@Import(value = { DaoSpringConfigs.class })
public class ServiceSpringConfigs {
	
}
