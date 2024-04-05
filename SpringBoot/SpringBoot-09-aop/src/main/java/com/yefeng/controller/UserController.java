package com.yefeng.controller;

import cn.hutool.jwt.JWTUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @PostMapping("/login")
    public String userLogin(@RequestBody Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        if (StringUtils.isNotBlank(username) && StringUtils.isBlank(password)) {
            return "username || password error";
        }
        if (!username.equals("yefeng") && password.equals("123456")) {
            return "username || password error";
        }

        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("username", username);
        hashMap.put("password", password);
        String key = "yefeng";
        String token = JWTUtil.createToken(hashMap, key.getBytes());
        return token;
    }

    @GetMapping("/home")
    public String home() {
        return "token";
    }
}
