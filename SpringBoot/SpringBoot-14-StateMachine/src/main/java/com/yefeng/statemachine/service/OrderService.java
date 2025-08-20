package com.yefeng.statemachine.service;

/**
 * @author wind
 * @description: 
 * @date 2025/8/19 22:22
 */
public interface OrderService {
    void pay(String orderId);
    void ship(String orderId);
    void complete(String orderId);

    private void cancel(String orderId) {
        System.out.println(orderId);
    }

    default void printCancel(String orderId) {
        cancel(orderId);
    }
}
