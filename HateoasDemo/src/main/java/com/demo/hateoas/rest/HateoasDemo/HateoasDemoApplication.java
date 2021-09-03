package com.demo.hateoas.rest.HateoasDemo;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class HateoasDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HateoasDemoApplication.class, args);
	}

	@Bean
	   public LocaleResolver localResolver() {
			AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
			localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
}
