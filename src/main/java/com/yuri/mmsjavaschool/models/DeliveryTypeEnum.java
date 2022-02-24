package com.yuri.mmsjavaschool.models;

import lombok.Getter;

@Getter
public enum DeliveryTypeEnum {
    COURIER("Courier delivery"),
    POST("Post delivery"),
    SELF_PICK("Self pickup");

    private final String name;

    DeliveryTypeEnum(String name) {
        this.name = name;
    }
}
