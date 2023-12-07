package com.xxx;

import com.xxx.dao.UserMapper;
import com.xxx.pojo.T_user;
import com.xxx.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
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
  static Logger logger = Logger.getLogger(UserDaoTest.class);
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
  public void log4jTest(){
    logger.info("info:进入了log4jTest");
    logger.debug("debug:进入了log4jTest");
    logger.error("error:进入了log4jTest");
  }

  @Test
  public void queryLimit(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    Map<Object, Object> map = new HashMap<>();
    map.put("startIndex", 0);
    map.put("pageIndex", 10);
    List<T_user> t_userLimit = mapper.getT_userLimit(map);
    for (T_user t_userList : t_userLimit) {
      System.out.println(t_userList.toString());
    }
    sqlSession.close();
  }

  @Test
  public void UserByRowBounds(){
    SqlSession sqlSession = MybatisUtils.getSqlSession();
//    RowBounds实现
    RowBounds rowBounds = new RowBounds(1, 2);
    List<T_user> t_userByRowBounds = sqlSession.selectList("com.xxx.dao.UserMapper.getT_userByRowBounds", null, rowBounds);
    for (T_user t_userByRowBound : t_userByRowBounds) {
      System.out.println(t_userByRowBound);
    }
    sqlSession.close();
  }
}
