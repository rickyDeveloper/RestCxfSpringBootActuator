package com.naiyar.repository;

import com.naiyar.domain.MongoProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by vikasnaiyar on 15/10/16.
 */
public interface MongoProductRepository extends MongoRepository<MongoProduct,String> {
    MongoProduct findById(String id);
}