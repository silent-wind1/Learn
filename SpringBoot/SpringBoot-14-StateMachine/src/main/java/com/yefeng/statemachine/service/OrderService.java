package com.yefeng.statemachine.service;

import com.yefeng.statemachine.model.entity.Order;

import java.util.Map;

/**
 * @author wind
 * @description: 
 * @date 2025/8/19 22:22
 */
public interface OrderService {
    Order create();
    void pay(long id);
    void deliver(long id);
    void receive(long id);
    Map<Long, Order> getOrders();
}
