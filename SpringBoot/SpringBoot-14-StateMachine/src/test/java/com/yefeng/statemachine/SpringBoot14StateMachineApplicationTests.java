package com.yefeng.statemachine;

import cn.hutool.json.JSONUtil;
import com.yefeng.statemachine.service.OrderService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

@SpringBootTest
class SpringBoot14StateMachineApplicationTests {

    @Resource
    private OrderService orderService;

    @Test
    void contextLoads() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            orderService.create();
            orderService.pay(1L);
            orderService.deliver(1L);
            orderService.receive(1L);
            countDownLatch.countDown();
        }).start();


        new Thread(() -> {
            orderService.create();
            orderService.pay(2L);
            orderService.deliver(2L);
            orderService.receive(2L);
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();

        System.out.println("订单处理完成:" + JSONUtil.toJsonStr(orderService.getOrders()));
    }

}
