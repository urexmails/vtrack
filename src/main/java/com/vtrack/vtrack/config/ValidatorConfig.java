//package com.vtrack.vtrack.config;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
//import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;
//
//@Configuration
//public class ValidatorConfig  {
//
//    @Bean
//    @Primary
//    public LocalValidatorFactoryBean validatorFactory(ApplicationContext context) {
//        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
//        factoryBean.setConstraintValidatorFactory(
//                new SpringConstraintValidatorFactory(context.getAutowireCapableBeanFactory())
//        );
//        return factoryBean;
//    }
//}