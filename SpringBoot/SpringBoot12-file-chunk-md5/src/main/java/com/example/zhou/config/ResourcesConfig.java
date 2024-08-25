package com.example.zhou.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 通用配置
 */
@Slf4j
@Configuration
public class ResourcesConfig implements WebMvcConfigurer {

    @Resource
    private FileUploadConfig fileUploadConfig;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置静态资源映射
        registry.addResourceHandler("/" + fileUploadConfig.getStaticAccessPath() + "/**")
                .addResourceLocations("file:" + fileUploadConfig.getUploadFolder() + "/");
        log.info("映射上传文件存储路径： {}", fileUploadConfig.getUploadFolder());
    }

}
