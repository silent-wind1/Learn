package com.yefeng.controller;

import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

    private final RedissonClient redissonClient;
    public TestController(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @RequestMapping("/hello")
    public String hello(){

        /**
         * 目标队列
         */
        RBlockingQueue<String> blockingRedPacketQueue = redissonClient.getBlockingQueue("userOrderKey");
        /**
         * 定时任务将到期的元素转移到目标队列
         */
        RDelayedQueue<String> delayedRedPacketQueue = redissonClient.getDelayedQueue(blockingRedPacketQueue);
        /**
         * 123456代表订单号，放入队列中
         * 设置10秒后到期
         */
        delayedRedPacketQueue.offer("123456", 10, TimeUnit.HOURS);
        return "OK";
    }
}