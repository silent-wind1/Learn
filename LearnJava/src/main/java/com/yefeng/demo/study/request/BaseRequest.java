package com.yefeng.demo.study.request;

import com.yefeng.demo.study.response.BaseResponse;
import lombok.Data;

/**
 * @Author: 叶枫
 * @Date: 2025/05/11/1:31
 * @Description: 请求类的基类
 */
@Data
public abstract class BaseRequest<T extends BaseResponse> {
    private String code;
    private String timestamp;
    private String sign;

    public abstract Class<T> getResponseType();
}
