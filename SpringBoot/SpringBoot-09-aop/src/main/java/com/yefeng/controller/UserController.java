package com.yefeng.controller;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @PostMapping("/login")
    public String userLogin(@RequestBody Map<String, String> map) {
        // 获取账号和密码
        String username = map.get("username");
        String password = map.get("password");
        // 进行校验
        if (StringUtils.isNotBlank(username) && StringUtils.isBlank(password)) {
            return "username || password error";
        }
        if (!username.equals("yefeng") && password.equals("123456")) {
            return "username || password error";
        }
        // 获取现在时间
        DateTime now = DateTime.now();
        // 过期时间为10分钟
        DateTime newTime = now.offsetNew(DateField.MINUTE, 10);

        Map<String, Object> payload = new HashMap();
        //签发时间
        payload.put(JWTPayload.ISSUED_AT, now);
        //过期时间
        payload.put(JWTPayload.EXPIRES_AT, newTime);
        //生效时间
        payload.put(JWTPayload.NOT_BEFORE, now);
        //载荷
        payload.put("username", username);
        payload.put("password", password);
        // 加密
        String key = "yefeng";
        String token = JWTUtil.createToken(payload, key.getBytes());
        System.out.println(token);
        return token;
    }

    @GetMapping("/home")
    public String home() {
        return "token";
    }
}
