package com.yefeng.statemachine.model.entity;

import lombok.Data;

/**
 * @author wind
 * @description:
 * @date 2025/8/21 20:17
 */
@Data
public class uploadFile {
    /**
     * 文件id
     */
    private String id;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 文件路径
     */
    private String filePath;
}
