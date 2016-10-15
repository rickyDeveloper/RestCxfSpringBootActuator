package com.naiyar.service;

import com.naiyar.domain.Product;
import com.naiyar.model.ProductVO;

import java.util.List;

/**
 * Created by vikasnaiyar on 15/10/16.
 */
public interface ProductService {

    ProductVO findProductsById(Long id);

    ProductVO saveProduct(ProductVO productVO);
}
