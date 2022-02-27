package com.yuri.mmsjavaschool.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address extends AbstractPO {
    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "town", nullable = false)
    private String town;
    @Column(name = "zip_code", nullable = false)
    private String zipCode;
    @Column(name = "street", nullable = false)
    private String street;
    @Column(name = "house_number", nullable = false)
    private String houseNumber;
    @Column(name = "apartment_number", nullable = false)
    private String apartmentNumber;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
