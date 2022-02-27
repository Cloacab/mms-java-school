package com.yuri.mmsjavaschool.models;


import javax.persistence.*;

@Entity
@Table(name = "order_to_product")
public class OrderProduct extends AbstractPO{

    @ManyToOne()
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "price_for_product")
    private Double priceForProduct;

    @Column(name = "amount")
    private Integer amount;
}
