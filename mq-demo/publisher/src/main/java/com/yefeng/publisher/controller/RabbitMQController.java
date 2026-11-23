package com.yefeng.publisher.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/mq")
public class RabbitMQController {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public void sendSimpleQueueMessage(String message) {
        log.info("message:{}", message);
        // 发送消息
        for (int i = 0; i < 10000; i++) {
            rabbitTemplate.convertAndSend("simple.queue", message + i);
        }
    }
}
