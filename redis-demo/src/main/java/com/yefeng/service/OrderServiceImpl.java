package com.yefeng.service;

import com.yefeng.entity.Events;
import com.yefeng.entity.Order;
import com.yefeng.entity.States;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: 叶枫
 * @Date: 2025/05/22/20:49
 * @Description:
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private StateMachine<States, Events> orderStateMachine;
    @Resource
    private StateMachinePersister<States, Events, String> stateMachineMemPersister;


    /**
     * 对订单进行支付
     *
     * @param id
     * @return
     */
    public Order pay(Long id) {
        Order order = new Order();
        order.setId(id);
        log.info("线程名称：{},尝试支付，订单号：{}" ,Thread.currentThread().getName() , id);
        if (!sendEvent(Events.PAYED, order)) {
            log.error("线程名称：{},支付失败, 状态异常，订单信息：{}", Thread.currentThread().getName(), order);
            throw new RuntimeException("支付失败, 订单状态异常");
        }
        return order;
    }
    @Override
    public Order getById(Long id) {

        return null;
    }
}
