package com.naiyar.service;

import com.naiyar.model.MongoProductVO;

/**
 * Created by vikasnaiyar on 15/10/16.
 */
public interface MongoProductService {
    MongoProductVO findProductsById(String id);

    MongoProductVO saveProduct(MongoProductVO productVO);
}
