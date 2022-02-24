package com.yuri.mmsjavaschool.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "payment_type")
public class PaymentType extends DeletableAbstractPO {
    @Column(name = "type")
    private PaymentTypeEnum type;
}