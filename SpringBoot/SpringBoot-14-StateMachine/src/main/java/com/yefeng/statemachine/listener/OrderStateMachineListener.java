package com.yefeng.statemachine.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

/**
 * 监听特定状态，并进行相关的业务处理
 */
@Slf4j
@Component
@WithStateMachine
public class OrderStateMachineListener {

    @OnTransition(target = "CREATED")
    public void onOrderCreated() {
        log.info("订单已创建...");
        // 在订单创建时，可以执行一些后续动作，例如初始化订单状态等
    }

    @OnTransition(target = "PAID")
    public void onPaymentProcessed() {
        log.info("订单支付已处理...");
        // 在订单支付完成时，可以执行一些后续动作，例如更新订单状态、发送通知等
    }

    @OnTransition(target = "SHIPPED")
    public void onOrderShipped() {
        log.info("订单已发货...");
        // 在订单发货完成时，可以执行一些后续动作，例如更新订单状态、发送通知等
    }

    @OnTransition(target = "COMPLETED")
    public void onOrderCompleted() {
        log.info("订单已完成...");
        // 在订单完成时，可以执行一些后续动作，例如更新订单状态、发送通知等
    }
}
