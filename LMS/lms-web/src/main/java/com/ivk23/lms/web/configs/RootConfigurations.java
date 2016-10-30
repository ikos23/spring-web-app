package com.ivk23.lms.web.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ivk23.lms.service.configs.ServiceSpringConfigs;

@Configuration
@ComponentScan(basePackages = { "com.ivk23.lms.web" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
@Import(value = { ServiceSpringConfigs.class })
public class RootConfigurations {

}
