package com.xxx.Dao;

import com.xxx.pojo.T_user;
import com.xxx.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserDaoTest
 * @Description TODO
 * @Author yefeng
 * @Date 2021/4/8 12:42
 * @Version 1.0
 */

public class UserDaoTest {
  @Test
  public void queryAllTest(){
//    获得SqlSession对象
    SqlSession sqlSession = MybatisUtils.getSqlSession();
//    方式一：getMapper
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    List<T_user> t_userList = mapper.getT_user();
    for (T_user user : t_userList) {
      System.out.println(user);
    }
//    关闭sqlSession
    sqlSession.close();
  }
  @Test
  public void getUserById(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    T_user userById = mapper.getUserById(1);
    System.out.println(userById);
    sqlSession.close();
  }
  @Test
  public void addT_user(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    int row = mapper.addT_user(new T_user(0, "杨圣波", "12356", 0));
    sqlSession.commit();
    System.out.println(row);
    sqlSession.close();
  }
  @Test
  public void updateT_user(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    int row = mapper.updateT_user(new T_user(4, "田思凯", "789456", 1));
    System.out.println(row);
    sqlSession.commit();
    sqlSession.close();
  }
  @Test
  public void deleteT_user(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    int row = mapper.deleteT_user(3);
    System.out.println(row);
    sqlSession.commit();
    sqlSession.close();

  }
  /* 万能的Map */
  @Test
  public void add_map(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    Map<String, Object> map = new HashMap<>();
    map.put("id", 8);
    map.put("name", "WE");
    map.put("pwd", "60E");
    map.put("member", 1);
    int row = mapper.addT_users(map);
    System.out.println(row);
    sqlSession.commit();
    sqlSession.close();
  }
}
