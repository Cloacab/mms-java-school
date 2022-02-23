package com.yuri.mmsjavaschool.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends AbstractPO {
    private String name;
    private Double price;
    @ManyToOne()
    private Category category;
//    private Parameters parameters;
    private Double weight;
    private Double volume;
    private Integer leftInStock;
}
