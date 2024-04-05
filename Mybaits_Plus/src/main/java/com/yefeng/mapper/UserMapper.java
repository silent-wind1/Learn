package com.yefeng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yefeng.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

//在对应的接口上面继承一个基本的接口 BaseMapper
@Repository//代表持久层
public interface UserMapper extends BaseMapper<User> {
    //所有CRUD操作都编写完成了，不用像以前一样配置一大堆文件
    // 自定义方法
    Map<String, Object> selectMapByID(Long id);

}
