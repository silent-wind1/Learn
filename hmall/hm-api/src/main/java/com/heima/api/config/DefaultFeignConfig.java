package com.heima.api.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * Openfeign日志类 配置
 */
public class DefaultFeignConfig {
    @Bean
    public Logger.Level feignLogLevel() {
        return Logger.Level.FULL;
    }
}