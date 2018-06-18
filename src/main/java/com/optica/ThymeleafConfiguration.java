package com.optica;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//
//@Configuration
//@EnableWebMvc
public class ThymeleafConfiguration {

//	
//	@Bean
//	public SpringTemplateEngine templateEngine() {
//		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//		templateEngine.setTemplateResolver(thymeleafTemplateResolver());
//		templateEngine.setAdditionalDialects( new HashSet<>(Arrays.asList(new SpringSecurityDialect())));
//		return templateEngine;
//	}
//
//	@Bean
//	public SpringResourceTemplateResolver thymeleafTemplateResolver() {
//	}
}
