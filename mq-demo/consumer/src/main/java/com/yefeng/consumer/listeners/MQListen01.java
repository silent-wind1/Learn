package com.yefeng.consumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wind
 * @description:
 * @date 2026/7/9 0:28
 */
@Slf4j
@Component
public class MQListen01 {

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessage(String msg)  {
        log.info("MQ Listen01接收到 simple.queue的消息：{}", msg);
    }
}
