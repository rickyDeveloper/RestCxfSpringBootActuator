package com.naiyar.service;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by vikasnaiyar on 11/10/16.
 */

@Path("/say")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api("/say")
@Service
public class HelloService {

    @GET
    public String sayHello(){
        return "Hello";
    }

}
