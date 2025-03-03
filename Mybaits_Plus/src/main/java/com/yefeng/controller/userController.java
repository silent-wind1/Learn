package com.yefeng.controller;

import com.yefeng.entity.User;
import com.yefeng.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 叶枫
 * @Date: 2025/03/02/21:20
 * @Description:
 */
@Slf4j
@RestController("/user")
@RequiredArgsConstructor
public class userController {

    private final UserService userService;

    @GetMapping("/list")
    public List<User> getUsers() {
        log.info("getUsers");
        return userService.list();
    }
}
