package com.yefeng.config;

import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AutoStart implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutoStart.class);

    @Autowired
    private RedissonClient redissonClient;


    @Override
    public void run(String... args) throws Exception {
        RBlockingQueue<String> blockingRedPacketQueue = redissonClient.getBlockingQueue("userOrderKey");

        RDelayedQueue<String> delayedRedPacketQueue = redissonClient.getDelayedQueue(blockingRedPacketQueue);
        while (true){
            /**
             * 如果当前没有失效的订单，则此循环会暂时阻塞
             * 取出超时订单信息
             */
            String redPacket = blockingRedPacketQueue.take();
            LOGGER.info("订单号:{}过期失效",redPacket);
            /**
             * 处理相关业务逻辑
             */
            delayedRedPacketQueue.
        }
    }
}