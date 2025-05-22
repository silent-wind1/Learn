package com.yefeng.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.RepositoryStateMachinePersist;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.statemachine.redis.RedisStateMachineContextRepository;
import org.springframework.statemachine.redis.RedisStateMachinePersister;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 叶枫
 * @Date: 2025/05/21/19:43
 * @Description:
 */
@Configuration
@Slf4j
public class Persist <E, S>{
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Resource
    private RedisConnectionFactory redisConnectionFactory;
    /**
     * 持久化到内存map中
     *
     * @return
     */
    @Bean(name = "stateMachineMemPersister")
    public static StateMachinePersister getPersister() {
        return new DefaultStateMachinePersister(new StateMachinePersist() {
            private Map map = new HashMap();
            @Override
            public void write(StateMachineContext context, Object contextObj) throws Exception {
                log.info("持久化状态机,context:{},contextObj:{}",  objectMapper.writeValueAsString(context), objectMapper.writeValueAsString(contextObj));
                map.put(contextObj, context);
            }

            @Override
            public StateMachineContext read(Object contextObj) throws Exception {
                log.info("获取状态机,contextObj:{}", objectMapper.writeValueAsString(contextObj));
                StateMachineContext stateMachineContext = (StateMachineContext) map.get(contextObj);
                log.info("获取状态机结果,stateMachineContext:{}", objectMapper.writeValueAsString(stateMachineContext));
                return stateMachineContext;
            }

        });
    }

    /**
     * 持久化到redis中，在分布式系统中使用
     *
     * @return
     */
    @Bean(name = "stateMachineRedisPersister")
    public RedisStateMachinePersister<E, S> getRedisPersister() {
        RedisStateMachineContextRepository<E, S> repository = new RedisStateMachineContextRepository<>(redisConnectionFactory);
        RepositoryStateMachinePersist p = new RepositoryStateMachinePersist<>(repository);
        return new RedisStateMachinePersister<>(p);
    }
}