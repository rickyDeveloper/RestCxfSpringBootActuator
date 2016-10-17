package com.naiyar.config;

import com.naiyar.cache.ProductCache;
import com.naiyar.repository.ProductRepository;
import com.naiyar.service.ProductService;
import com.naiyar.service.impl.ProductServiceImpl;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.CacheManager;
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
    public CounterService counterService() {
        return Mockito.mock(CounterService.class);
    }

    @Bean
    public ProductRepository productRepository(){
        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        return productRepository;
    }

    @Bean
    public ProductCache productCache(){
        return Mockito.mock(ProductCache.class);
    }

    @Bean
    public CacheManager cacheManager() {
        return Mockito.mock(CacheManager.class);
    }

}
