package com.naiyar.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by vikasnaiyar on 11/10/16.
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.naiyar"})
@EntityScan(basePackages = {"com.naiyar.domain"})
@EnableJpaRepositories(basePackages = {"com.naiyar.repository"})
@EnableMongoRepositories(basePackages = {"com.naiyar.repository"})
@EnableTransactionManagement
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class,args);
    }

    @Bean
    @ConditionalOnMissingBean
    public JacksonJsonProvider jsonProvider(ObjectMapper objectMapper) {
        JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
        provider.setMapper(objectMapper);
        return provider;
    }

    @Bean
    @ConditionalOnMissingBean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
