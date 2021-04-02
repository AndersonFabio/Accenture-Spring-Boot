package com.accenture.tarefas;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class TarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarefasApplication.class, args);
	}
	
	/*
	 * Create MessageSource bean
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new
				ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:ValidationMessages");
		return messageSource;
	}

	@Bean
	public LocalValidatorFactoryBean validator(){
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

	@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.getDefault());
		return sessionLocaleResolver;
	}
}
