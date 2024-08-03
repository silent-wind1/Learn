package com.yefeng.common;

import com.yefeng.constants.UserLoginConstants;
import com.yefeng.service.UserGranter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 策略工厂类
 */
@Component
public class UserLoginFactory {

	@Autowired
	private AccountGranter accountGranter;

	@Autowired
	private SmsGranter smsGranter;

	@Autowired
	private WeChatGranter weChatGranter;

	private static Map<String, UserGranter> granterPool = new ConcurrentHashMap<>();

	@PostConstruct
	public void init(){
		granterPool.put(UserLoginConstants.ACCOUNT_TYPE.getName(),accountGranter);
		granterPool.put(UserLoginConstants.PHONE_TYPE.getName(),smsGranter);
		granterPool.put(UserLoginConstants.WEB_CHAT_TYPE.getName(),weChatGranter);
	}
	
	/**
	 * 对外提供获取具体策略
	 */
	 public UserGranter getGranter(String grantType){
        UserGranter tokenGranter = granterPool.get(grantType);
        return tokenGranter;
    }

}