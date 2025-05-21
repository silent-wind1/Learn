package com.yefeng.entity;

import lombok.Getter;

/**
 * @Author: 叶枫
 * @Date: 2025/05/21/15:16
 * @Description: 定义状态
 */
@Getter
public enum States {
    WAIT_PAYMENT(1, "待支付"),
    WAIT_DELIVER(2, "待发货"),
    WAIT_RECEIVE(3, "待收货"),
    FINISH(4, "已完成");

    private Integer key;
    private String desc;
    States(Integer key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public static States getByKey(Integer key) {
        for (States e : values()) {
            if (e.getKey().equals(key)) {
                return e;
            }
        }
        throw new RuntimeException("enum not exists.");
    }
}