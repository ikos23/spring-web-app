package com.ivk23.lms.web.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ivk23.lms.commons.utils.DateUtils;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.ivk23.lms.web.controllers", "com.ivk23.lms.web.validators"})
public class WebConfigurations extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver("/app/", ".html");
		vr.setExposeContextBeansAsAttributes(true);
		return vr;
	}

	// configure static content handling
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer c) {
		c.enable();
	}
	
	// have no idea what for x_x. at least it does not break anything
	@Bean
	public FormattingConversionService dateConvertService() {

		// Use the DefaultFormattingConversionService but do not register
		// defaults
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);

		// Ensure @NumberFormat is still supported
		conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());
		
		// Register date conversion with a specific global format
        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
        registrar.setFormatter(new DateFormatter(DateUtils.DATE_FORMAT));
        registrar.registerFormatters(conversionService);

        return conversionService;
	}
	
}
