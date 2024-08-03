package com.yefeng.pojo;

import lombok.Data;

@Data
public class LoginResp{
    private Integer userId;
    private String userName;
    private String roleCode;
    private String token; //jwt令牌
    private boolean success;

}