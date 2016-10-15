package com.naiyar.controller;


import com.naiyar.model.MongoProductVO;
import com.naiyar.service.MongoProductService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by vikasnaiyar on 15/10/16.
 */
@Slf4j
@Path("/mongo/product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Setter
@Component
public class MongoProductController {

    @Autowired
    private MongoProductService mongoProductService;

    @GET
    @Path("/{id}")
    public MongoProductVO getProduct(@PathParam("id") String id) {
        log.info("Fetching product with id = {}", id);
        MongoProductVO vo = null;
        if (id != null) {
            vo = mongoProductService.findProductsById(id);
        }

        return vo;
    }

    @POST
    public MongoProductVO createProducts(MongoProductVO productVO) {
        log.info("Saving product to database");
        MongoProductVO vo = mongoProductService.saveProduct(productVO);
        return vo;
    }

}
