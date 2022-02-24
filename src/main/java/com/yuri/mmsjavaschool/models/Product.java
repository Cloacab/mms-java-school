package com.yuri.mmsjavaschool.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends AbstractPO {
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
//    private Parameters parameters;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "volume")
    private Double volume;
    @Column(name = "left_in_stock")
    private Integer leftInStock;
}
