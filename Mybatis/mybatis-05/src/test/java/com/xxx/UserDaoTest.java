package com.xxx;


import com.xxx.Dao.UserMapper;
import com.xxx.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//    查询
//    T_user t_userList = mapper.getT_userByID(2);
//    添加
//    mapper.addT_user(new T_user(3, "idea", "123456", 0));
//    修改
//      mapper.updateT_user( 3, "1456");
//    删除
      mapper.deleteT_userByID(3);
//    t_userList.toString();
//    关闭sqlSession
    sqlSession.close();
  }

  @Test
  public void add(){
    int p, i = 5;
    p = ++i + ++i + ++i;
    System.out.println(p + " " + i);
  }
}
