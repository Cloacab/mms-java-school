package com.yuri.mmsjavaschool.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "parameters")
@Getter
@Setter
public class Parameters extends AbstractPO {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "value", nullable = false)
    private String value;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
}
