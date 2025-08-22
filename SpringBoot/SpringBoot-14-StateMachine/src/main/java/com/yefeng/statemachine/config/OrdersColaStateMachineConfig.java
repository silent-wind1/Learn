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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wind
 * @description: 订单状态机配置类
 * @date 2025/8/22 12:23
 */
@Configuration
public class OrdersColaStateMachineConfig {

    @Resource
    private OrderMapper orderMapper;

    /**
     * 创建状态机
     * @return orderStateMachine
     */
    @Bean
    public StateMachine<OrderStatusEnum, OrderEventEnum, Order> stateMachine() {
        StateMachineBuilder<OrderStatusEnum, OrderEventEnum, Order> builder = StateMachineBuilderFactory.create();
        builder.externalTransition().from(OrderStatusEnum.WAIT_PAYMENT)//从待支付
                .to(OrderStatusEnum.WAIT_DELIVER)//变为待发货
                .on(OrderEventEnum.PAYED)//需要通过支付事件
                .when(o -> o.getOrderStatus().equals(OrderStatusEnum.WAIT_PAYMENT))//判断条件为传入的订单是待支付的
                .perform((f, t, e, o) -> {
                    System.out.println("将" + JSONUtil.toJsonStr(o) + " 由状态 " + f.getDescription() + " 变为 " + t.getDescription());
                    //上述要求符合后执行将状态修改为代发货，并持久化
                    o.setOrderStatus(OrderStatusEnum.WAIT_DELIVER);
                    orderMapper.put(o.getOrderId(), o);
                });


        builder.externalTransition().from(OrderStatusEnum.WAIT_DELIVER)//从待发货
                .to(OrderStatusEnum.WAIT_RECEIVE)//变为待收获
                .on(OrderEventEnum.DELIVERY)//通过发货事件
                .when(o -> true)//没有需要考虑的条件
                .perform((f, t, e, o) -> {//修改订单状态并持久化入库
                    o.setOrderStatus(OrderStatusEnum.WAIT_RECEIVE);
                    orderMapper.put(o.getOrderId(), o);
                    System.out.println("将" + JSONUtil.toJsonStr(o) + " 由状态 " + f.getDescription() + " 变为 " + t.getDescription());
                });

        builder.externalTransition().from(OrderStatusEnum.WAIT_RECEIVE)//从待收货
                .to(OrderStatusEnum.FINISH)//到已完成
                .on(OrderEventEnum.RECEIVED)//通过收获事件触发
                .when(o -> true)//无需任何条件校验
                .perform((f, t, e, o) -> {
                    //修改状态并持久化
                    o.setOrderStatus(OrderStatusEnum.FINISH);
                    orderMapper.put(o.getOrderId(), o);
                    System.out.println("将" + JSONUtil.toJsonStr(o) + " 由状态 " + f.getDescription() + " 变为 " + t.getDescription());
                });

        return builder.build("orderStateMachine");
    }
}
