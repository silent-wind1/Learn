package com.yefeng.statemachine;

import com.yefeng.statemachine.model.enums.OrderEvent;
import com.yefeng.statemachine.model.enums.OrderStatus;
import com.yefeng.statemachine.service.OrderService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;

@SpringBootTest
class SpringBoot14StateMachineApplicationTests {
    @Resource
    private StateMachine<OrderStatus, OrderEvent> stateMachine;

    @Resource
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        stateMachine.start();
    }

    @Test
    void contextLoads() {
        orderService.pay("1");
    }

}
