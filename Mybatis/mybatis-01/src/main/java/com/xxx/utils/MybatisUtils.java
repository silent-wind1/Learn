package com.xxx.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName MybatisUtils
 * @Description TODO
 * @Author yefeng
 * @Date 2021/4/8 12:19
 * @Version 1.0
 */

public class MybatisUtils {
  private static SqlSessionFactory sqlSessionFactory;
  static{
    try {
//    使用Mybatis第一步：获取 SqlSessionFactory对象
      String resource = "spring.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
//  既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
//  SqlSession 提供了在数据库执行 SQL 命令所需的所有方法
  public static SqlSession getSqlSession(){
    return sqlSessionFactory.openSession();
  }

}
