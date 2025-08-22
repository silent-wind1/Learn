package com.yefeng.statemachine.service.impl;

import cn.hutool.json.JSONUtil;
import com.alibaba.cola.statemachine.StateMachine;
import com.yefeng.statemachine.mapper.OrderMapper;
import com.yefeng.statemachine.model.entity.Order;
import com.yefeng.statemachine.model.enums.OrderEventEnum;
import com.yefeng.statemachine.model.enums.OrderStatusEnum;
import com.yefeng.statemachine.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wind
 * @description: 订单服务实现类
 * @date 2025/8/19 22:20
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    StateMachine<OrderStatusEnum, OrderEventEnum, Order> stateMachine;

    private final AtomicLong id = new AtomicLong(0);

    @Resource
    private OrderMapper orderMapper;


    public Order create() {
        //创建订单
        Order order = new Order();
        //初始化状态为待支付
        order.setOrderStatus(OrderStatusEnum.WAIT_PAYMENT);
        //分配id
        order.setOrderId(id.incrementAndGet());
        orderMapper.put(order.getOrderId(), order);

        System.out.println("订单创建成功:" + JSONUtil.toJsonStr(order));

        return order;
    }


    public void pay(long id) {
        //查询订单
        Order order = orderMapper.get(id);
        System.out.println("准备下单，订单号:" + id);
        //生成事件消息，希望将订单状态改为已支付，并存入当前订单数据
        stateMachine.fireEvent(order.getOrderStatus(), OrderEventEnum.PAYED, order);

    }


    public void deliver(long id) {
        Order order = orderMapper.get(id);
        System.out.println("准备给订单发货，订单号:" + id);
        //传入订单，并触发发货事件，成功后订单状态会改为待收货
        stateMachine.fireEvent(order.getOrderStatus(), OrderEventEnum.DELIVERY, order);
    }


    public void receive(long id) {
        Order order = orderMapper.get(id);
        System.out.println("尝试收货，订单号：" + id);
        //传入订单，并触发收货事件，将订单修改为已完成
        stateMachine.fireEvent(order.getOrderStatus(), OrderEventEnum.RECEIVED, order);
    }

    public Map<Long, Order> getOrders() {
        return orderMapper.getOrders();
    }
}
