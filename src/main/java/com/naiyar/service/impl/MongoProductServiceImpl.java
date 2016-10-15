package com.naiyar.service.impl;

import com.naiyar.domain.MongoProduct;
import com.naiyar.model.MongoProductVO;
import com.naiyar.repository.MongoProductRepository;
import com.naiyar.service.MongoProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vikasnaiyar on 15/10/16.
 */
@Service
@Slf4j
public class MongoProductServiceImpl implements MongoProductService{
    @Autowired
    private MongoProductRepository mongoProductRepository;

    public MongoProductVO findProductsById(String id) {
        log.info("Fetching product from db with id = {} ", id);
        MongoProductVO productVO = null;
        MongoProduct product = mongoProductRepository.findOne(id);
        if (product != null) {
            log.info("Product found with id = {}", id);
            productVO = new MongoProductVO();
            productVO.setId(product.getId());
            productVO.setName(product.getName());
            productVO.setPrice(product.getPrice());
            productVO.setRating(product.getRating());
        } else {
            log.warn("No product found with id = {}", id);
        }

        return productVO;
    }

    public MongoProductVO saveProduct(MongoProductVO productVO) {
        log.info("Saving product in db ");
        if (productVO != null) {
            MongoProduct product = null;
            if (productVO.getId() != null) {
                log.info("Looking up for product in db for id = {}", productVO.getId());
                product = mongoProductRepository.findOne(productVO.getId().toString());
            }

            if (product == null) {
                product = new MongoProduct();
            }
            product.setName(productVO.getName());
            product.setPrice(productVO.getPrice());
            product.setRating(productVO.getRating());

            mongoProductRepository.save(product);

            productVO.setId(product.getId());
        } else {
            log.warn("ProductVO object is null");
        }

        return productVO;
    }
}
