package com.naiyar.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by vikasnaiyar on 15/10/16.
 */
@Data
public class ProductVO {

    private Long id;

    @NotNull
    private String name;

    private double rating;

    private double price;

}
