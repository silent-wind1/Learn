package com.xxx.Dao;

import com.xxx.pojo.T_user;

import java.util.List;
import java.util.Map;

public interface UserMapper {
  List<T_user> getT_user();
  T_user getUserById(int i);
  int addT_user(T_user t_user);
  int updateT_user(T_user t_user);
  int deleteT_user(int id);
  int addT_users(Map<String, Object> map);
}
