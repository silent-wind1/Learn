package com.xxx.dao;

import com.xxx.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
  User queryUserById(@Param("id") int id);
  int updateUser(User user);
}
