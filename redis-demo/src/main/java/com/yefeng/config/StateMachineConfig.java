package com.yefeng.config;

import com.yefeng.entity.Events;
import com.yefeng.entity.States;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class StateMachineConfig extends StateMachineConfigurerAdapter<States, Events> {
    /**
     * 配置状态
     *
     * @param states 状态
     * @throws Exception 异常
     */
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states
                .withStates()
                .initial(States.WAIT_PAYMENT)
                .states(EnumSet.allOf(States.class));
    }

    /**
     * 配置状态转换事件关系
     *
     * @param transitions 变化
     * @throws Exception 异常
     */
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions
                //支付事件:待支付-》待发货
                .withExternal().source(States.WAIT_PAYMENT).target(States.WAIT_DELIVER).event(Events.PAYED)
                .and()
                //发货事件:待发货-》待收货
                .withExternal().source(States.WAIT_DELIVER).target(States.WAIT_RECEIVE).event(Events.DELIVERY)
                .and()
                //收货事件:待收货-》已完成
                .withExternal().source(States.WAIT_RECEIVE).target(States.FINISH).event(Events.RECEIVED);
    }

}