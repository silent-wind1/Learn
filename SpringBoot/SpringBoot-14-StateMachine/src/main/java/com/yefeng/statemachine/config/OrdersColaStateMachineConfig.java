package com.yefeng.statemachine.config;

import cn.hutool.json.JSONUtil;
import com.alibaba.cola.statemachine.StateMachine;
import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;
import com.yefeng.statemachine.mapper.OrderMapper;
import com.yefeng.statemachine.model.entity.Order;
import com.yefeng.statemachine.model.enums.OrderEventEnum;
import com.yefeng.statemachine.model.enums.OrderStatusEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wind
 * @description: 订单状态机配置类
 * @date 2025/8/22 12:23
 */
@Slf4j
@Configuration
public class OrdersColaStateMachineConfig {

    @Resource
    private OrderMapper orderMapper;

    /**
     * 创建状态机
     *
     * @return orderStateMachine
     */
    @Bean
    public StateMachine<OrderStatusEnum, OrderEventEnum, Order> stateMachine() {
        StateMachineBuilder<OrderStatusEnum, OrderEventEnum, Order> builder = StateMachineBuilderFactory.create();
        //从待支付
        builder.externalTransition().from(OrderStatusEnum.WAIT_PAYMENT)
                //变为待发货
                .to(OrderStatusEnum.WAIT_DELIVER)
                //需要通过支付事件
                .on(OrderEventEnum.PAYED)
                //判断条件为传入的订单是待支付的
                .when(o -> o.getOrderStatus().equals(OrderStatusEnum.WAIT_PAYMENT))
                //上述要求符合后执行将状态修改为代发货，并持久化
                .perform((f, t, e, o) -> {
                    log.info("订单状态变更: from={}, to={}, order={}", f.getDescription(), t.getDescription(), JSONUtil.toJsonStr(o));
                    o.setOrderStatus(OrderStatusEnum.WAIT_DELIVER);
                    orderMapper.put(o.getOrderId(), o);
                });


        builder.externalTransition().from(OrderStatusEnum.WAIT_DELIVER)
                //从待发货
                //变为待收获
                .to(OrderStatusEnum.WAIT_RECEIVE)
                //通过发货事件
                .on(OrderEventEnum.DELIVERY)
                //没有需要考虑的条件
                .when(o -> true)
                //修改订单状态并持久化入库
                .perform((f, t, e, o) -> {
                    log.info("订单状态变更: from={}, to={}, order={}", f.getDescription(), t.getDescription(), JSONUtil.toJsonStr(o));
                    o.setOrderStatus(OrderStatusEnum.WAIT_RECEIVE);
                    orderMapper.put(o.getOrderId(), o);
                });

        builder.externalTransition().from(OrderStatusEnum.WAIT_RECEIVE)
                //从待收货
                .to(OrderStatusEnum.FINISH)
                //到已完成
                .on(OrderEventEnum.RECEIVED)
                //通过收获事件触发
                .when(o -> true)
                //无需任何条件校验
                .perform((f, t, e, o) -> {
                    //修改状态并持久化
                    o.setOrderStatus(OrderStatusEnum.FINISH);
                    orderMapper.put(o.getOrderId(), o);
                    log.info("订单状态变更: from={}, to={}, order={}", f.getDescription(), t.getDescription(), JSONUtil.toJsonStr(o));
                });

        return builder.build("orderStateMachine");
    }
}
