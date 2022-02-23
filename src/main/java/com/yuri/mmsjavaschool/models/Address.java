package com.yuri.mmsjavaschool.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "adresses")
public class Address extends AbstractPO {
    @Column(name = "country")
    private String country;
    @Column(name = "town")
    private String town;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "street")
    private String street;
    @Column(name = "house_number")
    private String houseNumber;
    @Column(name = "apartment_number")
    private String apartmentNumber;
}
