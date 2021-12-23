package com.coding.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = "com.coding", exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableScheduling
public class AccumulateCoding {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(AccumulateCoding.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        System.out.println("-------开始打印beanDefinitionNames-------");
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }

}
