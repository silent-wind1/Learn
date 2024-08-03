package com.yefeng.pojo;

import lombok.Data;

@Data
public class LoginReq {

    private String name;
    private String password;

    private String phone;
    private String validateCode;//手机验证码

    private String wxCode;//用于微信登录
    /**
     * 0 : 用户名密码登录
     * 1 : 微信登录
     * 2 : 手机验证码登录
     */
    private String type;
}