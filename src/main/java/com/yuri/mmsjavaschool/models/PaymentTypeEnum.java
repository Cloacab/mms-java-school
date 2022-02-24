package com.yuri.mmsjavaschool.models;

import lombok.Getter;

@Getter
public enum PaymentTypeEnum {
    CREDIT_CARD("Credit card"),
    CASH("Cash");

    PaymentTypeEnum(String name) {
        this.name = name;
    }

    private final String name;
}
