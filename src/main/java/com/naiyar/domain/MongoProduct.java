package com.naiyar.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

/**
 * Created by vikasnaiyar on 15/10/16.
 */
@Getter
@Setter
public class MongoProduct {

    @Id
    private String id;

    private String name;

    private String rating;

    private String price;
}
