package com.naiyar.cache;

import com.naiyar.domain.MongoProduct;
import com.naiyar.repository.MongoProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by vikasnaiyar on 16/10/16.
 */
@Slf4j
@Component
public class MongoProductCache {

    @Autowired
    private MongoProductRepository mongoProductRepository;

    @Cacheable("mongoProducts")
    public MongoProduct getProduct(String id) {
       log.info("Fetching product from cache for id = {}", id);
       return  mongoProductRepository.findById(id);
    }

    public MongoProduct saveProduct(MongoProduct mongoProduct) {
        log.info("Saving product from cache for id = {}", mongoProduct.getId());
        return mongoProductRepository.save(mongoProduct);
    }
}
