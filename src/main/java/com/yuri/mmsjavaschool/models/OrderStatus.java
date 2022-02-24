package com.yuri.mmsjavaschool.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_status")
public class OrderStatus extends DeletableAbstractPO {
    @Column(name = "status")
    private OrderStatusEnum status;
}