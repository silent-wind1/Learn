package com.xxx.Dao;

import com.xxx.pojo.T_user;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
  @Select("select * from t_user")
  List<T_user> getT_userList();
//  方法存在多个参数，所有的参数前面必须加上@Param注解
  @Select("select * from t_user where id = #{id}")
  T_user getT_userByID(@Param("id") int id);
//  添加
  @Insert("insert into T_user values(#{id}, #{username}, #{pwd}, #{member})")
  int addT_user(T_user t_user);
//  修改
  @Update("update t_user set password = #{pwd}  where id = #{id}")
  int updateT_user(@Param("id") int id, @Param("pwd") String pwd);
//  删除
  @Delete("delete from t_user where id = #{id}")
  int deleteT_userByID(@Param("id") int id) ;
}
