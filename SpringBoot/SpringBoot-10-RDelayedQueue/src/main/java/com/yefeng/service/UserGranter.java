package com.yefeng.service;

import com.yefeng.pojo.LoginReq;
import com.yefeng.pojo.LoginResp;

/**
 * 抽象策略类
 */
public interface UserGranter{

   /**
    * 获取数据
    * @param loginReq 传入的参数
    * @return map值
    */
   LoginResp login(LoginReq loginReq);
}