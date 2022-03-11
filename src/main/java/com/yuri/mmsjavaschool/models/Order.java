package com.yuri.mmsjavaschool.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends AbstractPO {

    @ManyToOne()
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne()
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    private PaymentTypeEnum paymentType;

    @Column(name = "delivery_type")
    @Enumerated(EnumType.STRING)
    private DeliveryTypeEnum deliveryType;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Set<OrderProduct> orderProducts = new HashSet<>();

    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum paymentStatus;

    @Column(name = "delivery_status")
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;
}
