package com.yefeng.demo.study.response;

import lombok.Data;

/**
 * @Author: 叶枫
 * @Date: 2025/05/11/1:33
 * @Description:
 */
@Data
public abstract class BaseResponse {
    private String code;
    private String message;
    private String data;
    private String timestamp;
}
