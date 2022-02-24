package com.yuri.mmsjavaschool.models;

import lombok.Getter;

@Getter
public enum PaymentStatusEnum {
    AWAITING_PAYMENT("Awaiting payment"),
    PAYED("Payed");
    private final String name;

    PaymentStatusEnum(String name) {
        this.name = name;
    }
}
