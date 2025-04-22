package com.yefeng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.entity.User;
import com.yefeng.mapper.UserMapper;
import com.yefeng.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User findList() {
        return userMapper.selectById(3L);
    }

    @Override
    public List<User> getUsersByPage() {
        return userMapper.getUsersByPage();
    }
}
