package com.naiyar.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * Created by vikasnaiyar on 14/10/16.
 */
@Getter
@Setter
@Entity
@Table(name="products")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "products")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private double rating;

    private double price;

}
