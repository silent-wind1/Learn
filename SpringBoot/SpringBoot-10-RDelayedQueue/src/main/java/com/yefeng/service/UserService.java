package com.yefeng.service;

import com.yefeng.common.UserLoginFactory;
import com.yefeng.pojo.LoginReq;
import com.yefeng.pojo.LoginResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserLoginFactory factory;

    public LoginResp login(LoginReq loginReq){

        UserGranter granter = factory.getGranter(loginReq.getType());
        if(granter == null){
            LoginResp loginResp = new LoginResp();
            loginResp.setSuccess(false);
            return loginResp;
        }
        return granter.login(loginReq);
    }
}