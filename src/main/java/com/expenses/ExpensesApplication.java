package com.expenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;


@SpringBootApplication
@ComponentScan
@ImportResource({"classpath:context.xml"})
public class ExpensesApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ExpensesApplication.class, args);

//        displays all beans in the contex
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

//        this configuration is necassary to using security tags in thymeleaf templates
        SpringTemplateEngine templateEngine = (SpringTemplateEngine) ctx.getBean("templateEngine");
        Set<IDialect> dialects = new HashSet<IDialect>();
        dialects.add(new SpringSecurityDialect());
        templateEngine.setAdditionalDialects(dialects);

//        messages test
        MessageSource messageSource = (MessageSource) ctx.getBean("messageSource");
        String msg = messageSource.getMessage("menu.main.home", null, new Locale("pl"));
        System.out.println("XXX" + msg);


    }

}
