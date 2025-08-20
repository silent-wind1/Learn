package com.yefeng.statemachine.model.enums;

/**
 * 订单事件枚举
 */
public enum OrderEvent {
    PAY,      // 支付事件
    SHIP,     // 发货事件
    COMPLETE  // 完成事件
}