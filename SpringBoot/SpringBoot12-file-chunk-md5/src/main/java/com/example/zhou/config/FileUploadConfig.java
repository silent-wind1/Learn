package com.example.zhou.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ZhouQuan
 * @desciption 文件上传配置类
 * @date 2024/5/4 17:07
 */
@Data
@Component
@ConfigurationProperties(prefix = "file-upload.config")
public class FileUploadConfig {

    /**
     * 文件上传目录
     */
    private String uploadFolder;

    /**
     * 静态资源对外暴露的访问路径
     */
    private String staticAccessPath;

    /**
     * 文件上传访问域名
     */
    private String domain;

}
