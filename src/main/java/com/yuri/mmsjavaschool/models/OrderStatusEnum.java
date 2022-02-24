package com.yuri.mmsjavaschool.models;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    AWAITING_PAYMENT("Awaiting payment"),
    PAYED("Payed"),
    AWAITING_DELIVERY("Awaiting delivery"),
    DELIVERED("Delivered");
    private final String name;

    OrderStatusEnum(String name) {
        this.name = name;
    }
}
