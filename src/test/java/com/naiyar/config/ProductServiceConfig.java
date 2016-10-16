package com.naiyar.config;

import com.naiyar.repository.ProductRepository;
import com.naiyar.service.ProductService;
import com.naiyar.service.impl.ProductServiceImpl;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by vikasnaiyar on 16/10/16.
 */
@Configuration
public class ProductServiceConfig {

    @Bean
    public ProductService productService() {
        return new ProductServiceImpl();
    }

    @Bean
    public ProductRepository productRepository(){
        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        return productRepository;
    }
}
