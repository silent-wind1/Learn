package com.yefeng.statemachine.service.impl;

import com.yefeng.statemachine.model.enums.OrderEvent;
import com.yefeng.statemachine.model.enums.OrderStatus;
import com.yefeng.statemachine.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
/**
 * @author wind
 * @description: 订单服务实现类
 * @date 2025/8/19 22:20
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Resource
    private StateMachine<OrderStatus, OrderEvent> stateMachine;

    @Override
    public void pay(String orderId) {
        stateMachine.sendEvent(OrderEvent.PAY);
    }

    @Override
    public void ship(String orderId) {
        stateMachine.sendEvent(OrderEvent.SHIP);
    }

    @Override
    public void complete(String orderId) {
        stateMachine.sendEvent(OrderEvent.COMPLETE);
    }
}
