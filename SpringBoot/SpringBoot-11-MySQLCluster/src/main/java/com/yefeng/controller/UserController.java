package com.yefeng.controller;

import com.yefeng.annotation.Master;
import com.yefeng.model.User;
import com.yefeng.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 叶枫
 * @Date: 2024/06/16/21:06
 * @Description:
 */
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @RequestMapping("/list")
    public List<User> index() {
        return userService.selectList();
    }

    @Master
    @RequestMapping("/list1")
    public List<User> index1() {
        return userService.selectList();
    }
}
