package com.yefeng.statemachine.model.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    WAIT_PAYMENT(0, "待支付"), WAIT_DELIVER(1, "待发货"), WAIT_RECEIVE(2, "待收货"), FINISH(3, "完成");

    private int code;

    private String description;

    OrderStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

}