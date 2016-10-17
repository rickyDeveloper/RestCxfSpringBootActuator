package com.naiyar.controller;


import com.naiyar.model.ProductVO;
import com.naiyar.service.ProductService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by vikasnaiyar on 15/10/16.
 */

@Slf4j
@Path("/product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Setter
@Component
public class ProductController {

    @Autowired
    private ProductService productService;

    @GET
    @Path("/{id}")
    public ProductVO getProduct(@PathParam("id") Long id) {
        log.info("Fetching product with id = {}", id);
        ProductVO vo = null;
        if (id != null) {
            vo = productService.findProductsById(id);
        }

        return vo;
    }

    @GET
    @Path("/all")
    public Collection<ProductVO> getProducts() {
        log.info("Fetching allproduct");
        return productService.getAllProducts();
    }

    @GET
    @Path("/query")
    public Collection<ProductVO> getMathingProducts(@QueryParam(value = "text") String searchText) {
        log.info("Searching allproduct");
        return productService.getMatchingProducts(searchText);
    }

    @POST
    public ProductVO createProducts(ProductVO productVO) {
        log.info("Saving product to database");
        ProductVO vo = productService.saveProduct(productVO);
        return vo;
    }



}
