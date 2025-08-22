package com.yefeng.statemachine.mapper;

import com.yefeng.statemachine.model.entity.Order;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class OrderMapper {
    private Map<Long, Order> orders = new ConcurrentHashMap<>();

    public void put(Long id, Order order) {
        orders.put(id, order);
    }

    public Order get(Long id) {
        return orders.get(id);
    }

    public Map<Long, Order> getOrders() {
        return orders;
    }
}