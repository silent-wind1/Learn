package com.yefeng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yefeng.entity.User;
import org.springframework.stereotype.Repository;

//在对应的接口上面继承一个基本的接口 BaseMapper
@Repository //代表持久层
public interface UserMapper extends BaseMapper<User> {
}
