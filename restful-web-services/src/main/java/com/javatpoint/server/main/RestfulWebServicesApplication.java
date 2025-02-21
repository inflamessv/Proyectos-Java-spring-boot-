package com.javatpoint.server.main;

import java.util.Locale;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
		
		
	}
	
	@Bean
	public LocaleResolver localResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();  
		localeResolver.setDefaultLocale(Locale.US);  
		return localeResolver;  
	}
	
	@Bean
	public LocaleResolver localResolverFrance() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();  
		localeResolver.setDefaultLocale(Locale.FRANCE);  
		return localeResolver;  
	}
	
	/*configuring ResourceBundle  
	@Bean  
	public ResourceBundleMessageSource messageSource()  
	{  
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();  
		messageSource.setBasename("messages");  
		return messageSource;  
	}  

	*/
}
