package com.yefeng.statemachine.model.enums;

import lombok.Getter;

@Getter
public enum OrderEventEnum {

    PAYED(0,"已支付"),
    DELIVERY(1,"已发货"),
    RECEIVED(2,"已收货");

    private int code;
    private String description;

    OrderEventEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }
}