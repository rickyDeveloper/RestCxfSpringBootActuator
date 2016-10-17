package com.naiyar.service;


import com.naiyar.cache.ProductCache;
import com.naiyar.config.ProductServiceConfig;
import com.naiyar.domain.Product;
import com.naiyar.model.ProductVO;
import com.naiyar.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;

import static org.mockito.BDDMockito.*;

/**
 * Created by vikasnaiyar on 16/10/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ContextConfiguration(classes = ProductServiceConfig.class)
public class ProductServiceImplTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Before
    public void setup(){
    }

    @Test
    public void testfindProductsById() {
        log.info("ProductServiceImplTest testfindProductsById is running ");
        Long productId = 1L;
        String productName = "Test Product";
        double price = 53000.0;
        double rating = 4.5;

        when(this.productRepository.findOne(anyLong())).thenReturn(getDummyProduct(productId,productName,price,rating));

        ProductVO productVO = productService.findProductsById(1L);
        log.info("Product vo values is {} ", productVO);

        Assert.assertNotNull("ProductVO should not be null", productVO);
        Assert.assertEquals("Product id not matching", productId, (Long)productVO.getId());
        Assert.assertEquals("Product name should match", productName, productVO.getName());
        Assert.assertEquals("Product rating should match", rating, productVO.getRating(), 0.001);
        Assert.assertEquals("Product rating should match", rating, productVO.getRating(), 0.1);
    }


    @Test
    public void testSaveProduct() {
        log.info("ProductServiceImplTest testSaveProduct is running");

        Long productId = 1L;
        String productName = "Test Product";
        double price = 53000.0;
        double rating = 4.5;

        ProductVO productVO = getDummyProductVO(null,productName,price,rating);

        when(this.productRepository.save(any(Product.class))).thenReturn(getDummyProduct(productId,productName,price,rating));

        productVO = productService.saveProduct(productVO);

        log.info("Product vo values is {} ", productVO);

        Assert.assertEquals("Product id not matching", productId, (Long)productVO.getId());
        Assert.assertEquals("Product name should match", productName, productVO.getName());
        Assert.assertEquals("Product rating should match", rating, productVO.getRating(), 0.001);
        Assert.assertEquals("Product rating should match", rating, productVO.getRating(), 0.1);
    }



    private Product getDummyProduct(Long id, String name, Double price, Double rating) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setRating(rating);
        return product;
    }


    private ProductVO getDummyProductVO(Long id, String name, Double price, Double rating) {
        ProductVO productVO = new ProductVO();
        productVO.setId(id);
        productVO.setName(name);
        productVO.setPrice(price);
        productVO.setRating(rating);
        return productVO;
    }

}
