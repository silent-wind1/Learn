package com.yefeng.statemachine;

import cn.hutool.json.JSONUtil;
import com.yefeng.statemachine.model.entity.Order;
import com.yefeng.statemachine.service.OrderService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

@Slf4j
@SpringBootTest
class SpringBoot14StateMachineApplicationTests {

    @Resource
    private OrderService orderService;

    @Test
    void contextLoads() throws InterruptedException {
        //四个并发线程跑四种典型流程：正路、取消、超时关闭、申请退款 → 退款成功
        CountDownLatch latch = new CountDownLatch(4);
        new Thread(() -> happyPath(latch)).start();
        new Thread(() -> cancelBeforePay(latch)).start();
        new Thread(() -> closeByTimeout(latch)).start();
        new Thread(() -> refundFlow(latch)).start();
        latch.await();
        log.info("订单处理完成: {}", JSONUtil.toJsonStr(orderService.getOrders()));
    }

    /**
     * 正路：创建 → 支付 → 发货 → 收货
     */
    private void happyPath(CountDownLatch latch) {
        Order order = orderService.create();
        long id = order.getOrderId();
        orderService.pay(id);
        orderService.deliver(id);
        orderService.receive(id);
        latch.countDown();
    }

    /**
     * 边路1：创建 → 直接取消
     */
    private void cancelBeforePay(CountDownLatch latch) {
        Order order = orderService.create();
        long id = order.getOrderId();
        orderService.cancel(id);
        latch.countDown();
    }

    /**
     * 边路2：创建 → 取消（模拟超时关闭，可单独触发关闭定时任务）
     */
    private void closeByTimeout(CountDownLatch latch) {
        Order order = orderService.create();
        long id = order.getOrderId();
        //由定时任务调用 cancel 模拟超时关闭
        orderService.cancel(id);
        latch.countDown();
    }

    /**
     * 边路3：正路到待收货 → 申请退款 → 退款成功
     */
    private void refundFlow(CountDownLatch latch) {
        Order order = orderService.create();
        long id = order.getOrderId();
        orderService.pay(id);
        orderService.deliver(id);
        orderService.applyRefund(id);
        orderService.refundSuccess(id);
        latch.countDown();
    }
}
