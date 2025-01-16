package com.yefeng.publisher;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.yefeng.publisher.config.CorrelationDataConfig.*;

@SpringBootTest
@Slf4j
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSimpleQueue() {
        // 队列名称
        String queueName = "simple.queue";
        // 消息
        String message = "今天下午3点开会";
        // 发送消息
        rabbitTemplate.convertAndSend(queueName, message);
    }


//    @Test
//    public void testSendsQueue() {
//        // 队列名称
//        String queueName = "yefeng.fanout";
//        // 消息
//        String message = "今天下午3点开会";
//        // 发送消息
//        rabbitTemplate.convertAndSend(queueName, "", message);
//    }


    @Test
    public void testSendFanoutMessage() {
        // 交换机名称
        String exchangeName = "yefeng.fanout";
        String message = "明天下午3点面试";
        rabbitTemplate.convertAndSend(exchangeName, "yesterday", message);
    }


    @Test
    public void testSendsQueueTipple() {
        // 队列名称
        String queueName = "yefeng.topic";
        // 消息
        String message = "好吃不贵价格实惠";
        // 发送消息
        rabbitTemplate.convertAndSend(queueName, "china.food", message);
    }


    @Test
    public void testSendsQueueMap() {
        // 队列名称
        String queueName = "yefeng.topic";
        // 消息
        String message = "好吃不贵价格实惠";
        Map<String, Object> map = new HashMap<>();
        map.put("food", "面条");
        // 发送消息
        rabbitTemplate.convertAndSend(queueName, "china.food", map);
    }


    @Test
    void testPublisherConfirm() throws InterruptedException {
        // 3.发送消息
        rabbitTemplate.convertAndSend("hmall.direct", "q", "hello", initCD());

        Thread.sleep(30000);
    }


    @Test
    public void testSendsQueuePersistence() {
        // 队列名称
        String queueName = "lazy.queue";
        // 消息
        Message message = MessageBuilder
                .withBody("hello".getBytes(StandardCharsets.UTF_8))
                .setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT).build();
        // 发送消息
        for (int i = 0; i < 1000000; i++) {
            rabbitTemplate.convertAndSend(queueName, message);
        }
    }
    @Test
    void send() {
        String msg = "123&&123&&1&&";
        String delimiter = "&&";
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        int endIndex = msg.indexOf(delimiter);

        while (endIndex != -1) {
            result.add(msg.substring(startIndex, endIndex));
            startIndex = endIndex + delimiter.length();
            endIndex = msg.indexOf(delimiter, startIndex);
        }

        result.add(msg.substring(startIndex)); // 添加最后一个部分

        for (String s : result) {
            System.out.println(s);
        }
    }

}
