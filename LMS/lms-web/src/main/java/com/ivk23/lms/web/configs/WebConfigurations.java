// Spring Boot Auto-configs almost completely replace these configs!
// Some configs were overridden for Spring Security :)

package com.ivk23.lms.web.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = { "com.ivk23.lms.web.controllers", "com.ivk23.lms.web.validators" })
public class WebConfigurations extends WebMvcConfigurerAdapter /* implements ApplicationContextAware */ {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

//	
//	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
//		    "classpath:/static/", "classpath:/templates/" , "classpath:/templates/views/", "classpath:/static/images/", "classpath:/static/css/"};
//	
//	private ApplicationContext applicationContext;
//
//	 
//	// Thymeleaf 3.0 configs require ApplicationContext, so we need to implement ApplicationContextAware
//	// to be able to obtain it.
//	@Override
//	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		this.applicationContext = applicationContext;
//	}
//	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	    registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
//	}
//
//	
//	/* ======================================= THYMELEAF CONFIGS ======================================= */
//	@Bean
//	public ViewResolver thymeleafViewResolver() {
//		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//		resolver.setTemplateEngine(templateEngine());
//		resolver.setCharacterEncoding("UTF-8");
//		resolver.setOrder(0);
//		resolver.setViewNames(new String[] { "tl/*" });
//		return resolver;
//	}
//
//	@Bean
//	public TemplateEngine templateEngine() {
//		SpringTemplateEngine engine = new SpringTemplateEngine();
//		engine.setEnableSpringELCompiler(true);
//		engine.setTemplateResolver(templateResolver());
//		
//		StandardDialect sd = new StandardDialect();
//		sd.setConversionService(customConvertService());
//	 
//		engine.setDialect(sd);
//		
//		return engine;
//	}
//
//	@Bean
//	public ITemplateResolver templateResolver() {
//		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//		
//		resolver.setApplicationContext(applicationContext);
//		resolver.setPrefix("/views/");
//		resolver.setSuffix(".html");
//		resolver.setTemplateMode(TemplateMode.HTML);
//		resolver.setCharacterEncoding("UTF-8");
//		
//		return resolver;
//	}
//	
//	/* ================================================================================================= */
//	
//	@Bean
//	public ViewResolver viewResolver() {
//		InternalResourceViewResolver vr = new InternalResourceViewResolver("/app/", ".html");
//		vr.setExposeContextBeansAsAttributes(true);
//		vr.setOrder(1);
//		return vr;
//	}
//
//	// configure static content handling
//	@Override
//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer c) {
//		c.enable();
//	}
//
//	// have no idea what for x_x. at least it does not break anything
////	@Bean
////	public FormattingConversionService dateConvertService() {
////
////		// Use the DefaultFormattingConversionService but do not register
////		// defaults
////		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);
////
////		// Ensure @NumberFormat is still supported
////		conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());
////
////		// Register date conversion with a specific global format
////		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
////		registrar.setFormatter(new DateFormatter(DateUtils.DATE_FORMAT));
////		registrar.registerFormatters(conversionService);
////
////		return conversionService;
////	}
//	
//	private IStandardConversionService customConvertService() {
//		return new IStandardConversionService() {
//			
//			@SuppressWarnings("unchecked")
//			@Override
//			public <T> T convert(IExpressionContext context, Object object, Class<T> targetClass) {
//				if (targetClass.equals(String.class)) {
//					if (object == null || object instanceof String) {
//		                return (T) object;
//		            }
//					
//					if (object instanceof Date) {
//		            	return (T) new SimpleDateFormat("dd/MM/yyyy").format((Date)object);
//		            }
//		        }
//				
//				throw new IllegalArgumentException("No available conversion for target class \"" + targetClass.getName() + "\"");
//			}
//		};
//	}
//
}
