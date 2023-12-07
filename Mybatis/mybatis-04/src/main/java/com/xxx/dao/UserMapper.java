package com.xxx.dao;

import com.xxx.pojo.T_user;

import java.util.List;
import java.util.Map;

public interface UserMapper {
  List<T_user> getT_user();
  List<T_user> getT_userLimit(Map<Object, Object> map);
  List<T_user> getT_userByRowBounds();
}
