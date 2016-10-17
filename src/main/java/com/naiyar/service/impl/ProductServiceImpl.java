package com.naiyar.service.impl;

import com.naiyar.cache.ProductCache;
import com.naiyar.domain.Product;
import com.naiyar.model.ProductVO;
import com.naiyar.repository.ProductRepository;
import com.naiyar.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Created by vikasnaiyar on 14/10/16.
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private CounterService counterService;


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCache productCache;


    public ProductVO findProductsById(Long id) {
        log.info("Fetching product from db with id = {} ", id);
        this.counterService.increment("services.system.productservice.invoked");
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
        this.counterService.increment("services.system.productservice.invoked");
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


    public Collection<ProductVO> getAllProducts() {
        log.info("Loading all products...");
        this.counterService.increment("services.system.productservice.invoked");
        Collection<Product> allProducts = productCache.getAllProducts();
        return getProductVOs(allProducts);
    }


    @Override
    public Collection<ProductVO> getMatchingProducts(String searchText) {
        Collection<Product> allProducts = productRepository.findByNameContaining(searchText);
        return getProductVOs(allProducts);
    }

    private Collection<ProductVO> getProductVOs(Collection<Product> products) {
        if(products == null) {
            return Collections.EMPTY_LIST;
        }

        Collection<ProductVO> productVOs =
                products.stream().map(
                        product -> {
                            ProductVO productVO = new ProductVO();
                            productVO.setId(product.getId());
                            productVO.setName(product.getName());
                            productVO.setPrice(product.getPrice());
                            productVO.setRating(product.getRating());
                            return productVO;
                        }
                ).collect(Collectors.toCollection(HashSet::new));

        return productVOs;
    }



}
