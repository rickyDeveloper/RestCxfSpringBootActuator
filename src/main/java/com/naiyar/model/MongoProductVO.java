package com.naiyar.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by vikasnaiyar on 15/10/16.
 */
@Data
public class MongoProductVO {

    private String id;

    @NotNull
    private String name;

    private String rating;

    private String price;
}
