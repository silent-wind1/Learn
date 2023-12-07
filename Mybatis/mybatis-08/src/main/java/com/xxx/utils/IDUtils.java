package com.xxx.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * @ClassName IDUtils
 * @Description TODO
 * @Author yefeng
 * @Date 2021/4/19 16:20
 * @Version 1.0
 */
//@SuppressWarnings("all")  // 抑制警告
public class IDUtils {
  public static String getID(){
    return UUID.randomUUID().toString().replaceAll("-", "");
  }
  @Test
  public void test(){
    System.out.println(IDUtils.getID());
    System.out.println(IDUtils.getID());
    System.out.println(IDUtils.getID());
  }
}
