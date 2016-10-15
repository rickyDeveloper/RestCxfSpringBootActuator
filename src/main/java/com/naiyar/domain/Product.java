package com.naiyar.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by vikasnaiyar on 14/10/16.
 */
@Getter
@Setter
@Entity
//@Table(name="products")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private double rating;

    private double price;

}
