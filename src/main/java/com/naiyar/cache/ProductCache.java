package com.naiyar.cache;

import com.naiyar.domain.Product;
import com.naiyar.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;

/**
 * Created by vikasnaiyar on 16/10/16.
 */
@Service
@Slf4j
public class ProductCache {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CacheManager cacheManager;

    @PostConstruct
    public void init(){
        loadProductTable();
    }

    @Cacheable("allProducts")
    public Collection<Product> getAllProducts() {
        log.info("Fetching products from database");
        return productRepository.findAll();
    }

    private void loadProductTable() {
        log.info("Loading products from database");
        List<Product> products = productRepository.findAll();
        log.info("Found {} products in db", (products == null ? 0 : products.size()));
        for (Product product: products) {
          cacheManager.getCache("allProducts").put(product.getId(), product);
        }
    }
}
