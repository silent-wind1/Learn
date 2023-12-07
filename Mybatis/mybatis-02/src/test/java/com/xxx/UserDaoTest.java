package com.xxx;

import com.xxx.Dao.UserMapper;
import com.xxx.pojo.T_user;
import com.xxx.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

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

}
