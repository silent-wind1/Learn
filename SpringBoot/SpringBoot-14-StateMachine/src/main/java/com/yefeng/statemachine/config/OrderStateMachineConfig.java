package com.yefeng.statemachine.config;

import com.yefeng.statemachine.model.enums.OrderEvent;
import com.yefeng.statemachine.model.enums.OrderStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

@Configuration
@EnableStateMachine // 启用状态机
public class OrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderStatus, OrderEvent> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<OrderStatus, OrderEvent> config) throws Exception {
        config.withConfiguration()
                // 应用启动时自动启动状态机
                .autoStartup(true)
                // 设置状态机监听器
                .listener(listener());
    }

    /**
     * 配置状态机的初始状态和所有可能的状态
     *
     * @param states 状态机配置
     * @throws Exception 异常
     */
    @Override
    public void configure(StateMachineStateConfigurer<OrderStatus, OrderEvent> states) throws Exception {
        states.withStates()
                // 设置初始状态为 CREATED
                .initial(OrderStatus.CREATED)
                // 添加所有可能的状态
                .states(EnumSet.allOf(OrderStatus.class));
    }

    /**
     * 配置状态机的状态转换规则
     *
     * @param transitions 状态机转换配置
     * @throws Exception 异常
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStatus, OrderEvent> transitions) throws Exception {
        // 定义外部状态转换
        transitions.withExternal()
                // 从 CREATED 状态转换到 PAID 状态，当触发 PAY 事件时
                .source(OrderStatus.CREATED).target(OrderStatus.PAID).event(OrderEvent.PAY).and() // 连接下一个状态转换
                .withExternal() // 定义外部状态转换
                // 从 PAID 状态转换到 SHIPPED 状态，当触发 SHIP 事件时
                .source(OrderStatus.PAID).target(OrderStatus.SHIPPED).event(OrderEvent.SHIP).and() // 连接下一个状态转换
                .withExternal() // 定义外部状态转换
                // 从 SHIPPED 状态转换到 COMPLETED 状态，当触发 COMPLETE 事件时
                .source(OrderStatus.SHIPPED).target(OrderStatus.COMPLETED).event(OrderEvent.COMPLETE);
    }

    @Bean
    public StateMachineListener<OrderStatus, OrderEvent> listener() {
        return new StateMachineListenerAdapter<>() {
            @Override
            public void stateChanged(State<OrderStatus, OrderEvent> from, State<OrderStatus, OrderEvent> to) {
                System.out.println("State change to " + to.getId());
            }
        };
    }
}
