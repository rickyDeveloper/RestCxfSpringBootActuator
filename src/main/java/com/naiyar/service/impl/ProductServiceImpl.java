package com.naiyar.service.impl;

import com.naiyar.domain.Product;
import com.naiyar.model.ProductVO;
import com.naiyar.repository.ProductRepository;
import com.naiyar.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vikasnaiyar on 14/10/16.
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductVO findProductsById(Long id) {
        log.info("Fetching product from db with id = {} ", id);
        ProductVO productVO = null;
        Product product = productRepository.findOne(id);
        if (product != null) {
            log.info("Product found with id = {}", id);
            productVO = new ProductVO();
            productVO.setId(product.getId());
            productVO.setName(product.getName());
            productVO.setPrice(product.getPrice());
            productVO.setRating(product.getRating());
        } else {
            log.warn("No product found with id = {}", id);
        }

        return productVO;
    }

    public ProductVO saveProduct(ProductVO productVO) {
        log.info("Saving product in db ");
        if (productVO != null) {
            Product product = null;
            if (productVO.getId() != null) {
                product = productRepository.findOne(productVO.getId());
            }

            if (product == null) {
                product = new Product();
            }
            product.setName(productVO.getName());
            product.setPrice(productVO.getPrice());
            product.setRating(productVO.getRating());

            product = productRepository.save(product);

            productVO.setId(product.getId());
        } else {
            log.warn("ProductVO object is null");
        }

        return productVO;
    }

}
