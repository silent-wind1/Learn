package com.yefeng.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.api")
public class AliyunApiConfig {
    private String host;
    private String path;
    private String method;
    private String appcode;
    private String appKey;
    private String appSecret;
}