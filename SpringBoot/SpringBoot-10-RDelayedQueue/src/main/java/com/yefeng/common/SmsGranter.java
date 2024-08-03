package com.yefeng.common;

import com.yefeng.pojo.LoginReq;
import com.yefeng.pojo.LoginResp;
import com.yefeng.service.UserGranter;
import org.springframework.stereotype.Component;

/**
 * 策略:短信登录
 */
@Component
public class SmsGranter implements UserGranter {

	@Override
	public LoginResp login(LoginReq loginReq)  {

		System.out.println("登录方式为短信登录" + loginReq);
		// TODO
		// 执行业务操作

		return new LoginResp();
	}
}