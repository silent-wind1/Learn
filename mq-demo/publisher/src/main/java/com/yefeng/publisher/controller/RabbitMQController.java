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

    @GetMapping("/simple")
    public void sendSimpleQueueMessage(String message) {
        log.info("simple message:{}", message);
        // 发送消息
        rabbitTemplate.convertAndSend("simple.queue", message);
    }


    @GetMapping("/work")
    public void sendWorkQueueMessage(String message) {
        log.info("work message:{}", message);
        // 发送消息
        rabbitTemplate.convertAndSend("work.queue", "", message);
    }

    @GetMapping("/delay")
    public void sendDelayQueueMessage(String message) {

        // 发送一个延迟消息
        rabbitTemplate.convertAndSend("work.queue", "", message);
    }


    @GetMapping("/direct")
    public void sendDirectExchange() {
        // 交换机名称
        String exchangeName = "yefeng.direct";
        // 消息
        String message = "又过去一年了，23年的我知道吗？估计在25年我与你相遇，24年的你辛苦了";
        // 发送消息
        rabbitTemplate.convertAndSend(exchangeName, "red", message);

        message = "现在是2026年11月24日，过去的我，我现在还没有找到工作。如今我又把RabbitMQ学了一下，我觉得我还是有很多地方不会用。";
        // 发送消息
        rabbitTemplate.convertAndSend(exchangeName, "blue", message);
    }

}
