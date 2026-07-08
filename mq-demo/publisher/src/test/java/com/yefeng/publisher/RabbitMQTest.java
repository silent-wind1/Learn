package com.yefeng.publisher;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;

/**
 * @author wind
 * @description:
 * @date 2026/7/9 0:45
 */
@SpringBootTest
@Slf4j
public class RabbitMQTest {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMsg() {
        String queueName = "simple.queue";
        String message = "今天是%s,我还是没有找到工作, 离职时间是2025-12-31".formatted(LocalDate.now());
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
