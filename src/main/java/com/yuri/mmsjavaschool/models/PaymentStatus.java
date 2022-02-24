package com.yuri.mmsjavaschool.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "payment_status")
public class PaymentStatus extends DeletableAbstractPO {
    @Column(name = "status")
    private PaymentStatusEnum status;
}