package com.yefeng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.entity.User;
import com.yefeng.mapper.UserMapper;
import com.yefeng.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User findList() {
        UserMapper userMapper = getBaseMapper();
        return userMapper.selectById(3L);
    }
}
