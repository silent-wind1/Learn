package com.yefeng.statemachine.config;

import com.alibaba.cola.statemachine.StateMachine;
import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;
import com.yefeng.statemachine.mapper.OrderDao;
import com.yefeng.statemachine.model.entity.Order;
import com.yefeng.statemachine.model.enums.OrderEventEnum;
import com.yefeng.statemachine.model.enums.OrderStatusEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wind
 * @description: 订单状态机配置类（落库版，含边路状态）
 * @date 2025/8/22 12:23
 */
@Slf4j
@Configuration
public class OrdersColaStateMachineConfig {

    @Resource
    private OrderDao orderDao;

    /**
     * 创建状态机
     *
     * @return orderStateMachine
     */
    @Bean
    public StateMachine<OrderStatusEnum, OrderEventEnum, Order> stateMachine() {

        StateMachineBuilder<OrderStatusEnum, OrderEventEnum, Order> builder = StateMachineBuilderFactory.create();

        //正路：待支付 --PAYED--> 待发货
        builder.externalTransition().from(OrderStatusEnum.WAIT_PAYMENT)
                //变为待发货
                .to(OrderStatusEnum.WAIT_DELIVER)
                //需要通过支付事件
                .on(OrderEventEnum.PAYED)
                //判断条件为传入的订单是待支付的
                .when(o -> o.getOrderStatus().equals(OrderStatusEnum.WAIT_PAYMENT))
                //条件符合后修改订单状态并持久化
                .perform((f, t, e, o) -> {
                    log.info("订单状态变更: from={}, to={}, orderId={}", f.getDescription(), t.getDescription(), o.getOrderId());
                    o.setOrderStatus(OrderStatusEnum.WAIT_DELIVER);
                    orderDao.updateById(o);
                });

        //正路：待发货 --DELIVERY--> 待收货
        builder.externalTransition().from(OrderStatusEnum.WAIT_DELIVER)
                //从待发货
                //变为待收获
                .to(OrderStatusEnum.WAIT_RECEIVE)
                //通过发货事件
                .on(OrderEventEnum.DELIVERY)
                //没有需要考虑的条件
                .when(o -> true)
                //修改订单状态并持久化
                .perform((f, t, e, o) -> {
                    log.info("订单状态变更: from={}, to={}, orderId={}", f.getDescription(), t.getDescription(), o.getOrderId());
                    o.setOrderStatus(OrderStatusEnum.WAIT_RECEIVE);
                    orderDao.updateById(o);
                });

        //正路：待收货 --RECEIVED--> 完成
        builder.externalTransition().from(OrderStatusEnum.WAIT_RECEIVE)
                //从待收货
                .to(OrderStatusEnum.FINISH)
                //到已完成
                .on(OrderEventEnum.RECEIVED)
                //通过收获事件触发
                .when(o -> true)
                //无需任何条件校验
                .perform((f, t, e, o) -> {
                    o.setOrderStatus(OrderStatusEnum.FINISH);
                    orderDao.updateById(o);
                    log.info("订单状态变更: from={}, to={}, orderId={}", f.getDescription(), t.getDescription(), o.getOrderId());
                });

        //边路1：待支付 --CANCEL--> 已取消
        builder.externalTransition().from(OrderStatusEnum.WAIT_PAYMENT)
                //从待支付
                .to(OrderStatusEnum.CANCELED)
                //变为已取消
                .on(OrderEventEnum.CANCEL)
                //通过取消事件
                .when(o -> o.getOrderStatus().equals(OrderStatusEnum.WAIT_PAYMENT))
                //只有待支付状态允许取消
                .perform((f, t, e, o) -> {
                    o.setOrderStatus(OrderStatusEnum.CANCELED);
                    orderDao.updateById(o);
                    log.info("订单状态变更: from={}, to={}, orderId={}", f.getDescription(), t.getDescription(), o.getOrderId());
                });

        //边路2：待支付 --(超时未支付)--> 已关闭
        builder.externalTransition().from(OrderStatusEnum.WAIT_PAYMENT)
                //从待支付
                .to(OrderStatusEnum.CLOSED)
                //变为已关闭
                .on(OrderEventEnum.CANCEL)
                //通过取消事件复用，由定时任务触发关闭
                .when(o -> o.getOrderStatus().equals(OrderStatusEnum.WAIT_PAYMENT))
                //待支付状态允许关闭
                .perform((f, t, e, o) -> {
                    o.setOrderStatus(OrderStatusEnum.CLOSED);
                    orderDao.updateById(o);
                    log.info("订单状态变更: from={}, to={}, orderId={}", f.getDescription(), t.getDescription(), o.getOrderId());
                });

        //边路3：待发货 --CANCEL--> 已取消（商家缺货等情况）
        builder.externalTransition().from(OrderStatusEnum.WAIT_DELIVER)
                //从待发货
                .to(OrderStatusEnum.CANCELED)
                //变为已取消
                .on(OrderEventEnum.CANCEL)
                //通过取消事件
                .when(o -> o.getOrderStatus().equals(OrderStatusEnum.WAIT_DELIVER))
                //只有待发货状态允许取消
                .perform((f, t, e, o) -> {
                    o.setOrderStatus(OrderStatusEnum.CANCELED);
                    orderDao.updateById(o);
                    log.info("订单状态变更: from={}, to={}, orderId={}", f.getDescription(), t.getDescription(), o.getOrderId());
                });

        //边路4：待收货 --APPLY_REFUND--> 退款中
        builder.externalTransition().from(OrderStatusEnum.WAIT_RECEIVE)
                //从待收货
                .to(OrderStatusEnum.REFUNDING)
                //变为退款中
                .on(OrderEventEnum.APPLY_REFUND)
                //通过申请退款事件
                .when(o -> o.getOrderStatus().equals(OrderStatusEnum.WAIT_RECEIVE))
                //只有待收货状态允许申请退款
                .perform((f, t, e, o) -> {
                    o.setOrderStatus(OrderStatusEnum.REFUNDING);
                    orderDao.updateById(o);
                    log.info("订单状态变更: from={}, to={}, orderId={}", f.getDescription(), t.getDescription(), o.getOrderId());
                });

        //边路5：完成 --APPLY_REFUND--> 退款中（售后）
        builder.externalTransition().from(OrderStatusEnum.FINISH)
                //从完成
                .to(OrderStatusEnum.REFUNDING)
                //变为退款中
                .on(OrderEventEnum.APPLY_REFUND)
                //通过申请退款事件
                .when(o -> o.getOrderStatus().equals(OrderStatusEnum.FINISH))
                //只有完成状态允许申请售后退款
                .perform((f, t, e, o) -> {
                    o.setOrderStatus(OrderStatusEnum.REFUNDING);
                    orderDao.updateById(o);
                    log.info("订单状态变更: from={}, to={}, orderId={}", f.getDescription(), t.getDescription(), o.getOrderId());
                });

        //边路6：退款中 --REFUND_SUCCESS--> 已退款
        builder.externalTransition().from(OrderStatusEnum.REFUNDING)
                //从退款中
                .to(OrderStatusEnum.REFUNDED)
                //变为已退款
                .on(OrderEventEnum.REFUND_SUCCESS)
                //通过退款成功事件
                .when(o -> o.getOrderStatus().equals(OrderStatusEnum.REFUNDING))
                //只有退款中状态允许变更为已退款
                .perform((f, t, e, o) -> {
                    o.setOrderStatus(OrderStatusEnum.REFUNDED);
                    orderDao.updateById(o);
                    log.info("订单状态变更: from={}, to={}, orderId={}", f.getDescription(), t.getDescription(), o.getOrderId());
                });

        return builder.build("orderStateMachine");
    }
}
