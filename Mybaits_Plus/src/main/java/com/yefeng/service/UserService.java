package com.yefeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yefeng.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    User findList();

    List<User> getUsersByPage();
}
