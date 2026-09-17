package com.yefeng.statemachine.service.impl;

import cn.hutool.json.JSONUtil;
import com.alibaba.cola.statemachine.StateMachine;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.yefeng.statemachine.mapper.OrderDao;
import com.yefeng.statemachine.model.entity.Order;
import com.yefeng.statemachine.model.enums.OrderEventEnum;
import com.yefeng.statemachine.model.enums.OrderStatusEnum;
import com.yefeng.statemachine.service.OrderService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wind
 * @description: 订单服务实现类（MyBatis-Plus 落库版）
 * @date 2025/8/19 22:20
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private StateMachine<OrderStatusEnum, OrderEventEnum, Order> stateMachine;

    @Resource
    private OrderDao orderDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Order create() {
        //创建订单
        Order order = new Order();
        //使用雪花算法生成全局唯一订单号
        order.setOrderId(IdWorker.getId());
        //初始化状态为待支付
        order.setOrderStatus(OrderStatusEnum.WAIT_PAYMENT);
        //写入数据库
        orderDao.insert(order);
        log.info("订单创建成功: {}", JSONUtil.toJsonStr(order));
        return order;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pay(long id) {
        Order order = getOrderOrLog(id);
        if (order == null) return;
        log.info("准备支付, id={}", id);
        //触发支付事件，状态机内部回调 perform() 完成 setStatus + updateById
        stateMachine.fireEvent(order.getOrderStatus(), OrderEventEnum.PAYED, order);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deliver(long id) {
        Order order = getOrderOrLog(id);
        if (order == null) return;
        log.info("准备发货, id={}", id);
        //传入订单，并触发发货事件，成功后订单状态会改为待收货
        stateMachine.fireEvent(order.getOrderStatus(), OrderEventEnum.DELIVERY, order);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void receive(long id) {
        Order order = getOrderOrLog(id);
        if (order == null) return;
        log.info("尝试收货, id={}", id);
        //传入订单，并触发收货事件，将订单修改为已完成
        stateMachine.fireEvent(order.getOrderStatus(), OrderEventEnum.RECEIVED, order);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancel(long id) {
        Order order = getOrderOrLog(id);
        if (order == null) return;
        log.info("尝试取消订单, id={}", id);
        //触发取消事件：状态机会根据当前状态路由到 CANCELED 或 CLOSED
        stateMachine.fireEvent(order.getOrderStatus(), OrderEventEnum.CANCEL, order);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void applyRefund(long id) {
        Order order = getOrderOrLog(id);
        if (order == null) return;
        log.info("申请退款, id={}", id);
        //触发申请退款事件：待收货或已完成均可进入 REFUNDING
        stateMachine.fireEvent(order.getOrderStatus(), OrderEventEnum.APPLY_REFUND, order);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void refundSuccess(long id) {
        Order order = getOrderOrLog(id);
        if (order == null) return;
        log.info("退款成功回调, id={}", id);
        //外部支付平台回调触发，状态由 REFUNDING 变为 REFUNDED
        stateMachine.fireEvent(order.getOrderStatus(), OrderEventEnum.REFUND_SUCCESS, order);
    }

    @Override
    public List<Order> getOrders() {
        //查询全部订单（自动过滤逻辑删除）
        return orderDao.selectList(null);
    }

    /**
     * 查询订单并打日志，不存在返回 null
     */
    private Order getOrderOrLog(long id) {
        Order order = orderDao.selectById(id);
        if (order == null) {
            log.warn("订单不存在, id={}", id);
        }
        return order;
    }
}
