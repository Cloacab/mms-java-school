package com.yuri.mmsjavaschool.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends AbstractPO {
    @ManyToOne()
    private Client client;
    @OneToOne()
    private Address address;
    private PaymentType paymentType;
    private DeliveryType deliveryType;
    @ManyToOne()
    private Product product;
    private PaymentStatus paymentStatus;
    private OrderStatus orderStatus;
}
