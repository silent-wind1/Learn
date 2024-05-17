package com.yefeng;

import com.yefeng.pojo.CancelOrder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringBoot10RDelayedQueueApplicationTests {

    @Test
    void contextLoads() throws InterruptedException {
        DelayQueue<CancelOrder> queue = new DelayQueue<>();
        for (int i = 0; i < 5; i++) {
            // 生成订单，10秒超时
            CancelOrder cancelOrder = new CancelOrder("orderNo100" + i, TimeUnit.NANOSECONDS.convert(10, TimeUnit.SECONDS));
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println(time + ":生成了订单，10秒有效期，order：" + cancelOrder);
            queue.put(cancelOrder);
            // 每1秒生成一个订单
            Thread.sleep(1000);
        }
        try {
            while (!queue.isEmpty()) {
                CancelOrder order = queue.take();
                String timeout = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                System.out.println(timeout + ":订单超时，order：" + order);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
