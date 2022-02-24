package com.yuri.mmsjavaschool.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "delivery_type")
public class DeliveryType extends DeletableAbstractPO {
    @Column(name = "type")
    private DeliveryTypeEnum type;
}