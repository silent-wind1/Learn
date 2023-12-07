package com.xxx.pojo;

import lombok.Data;

/**
 * @ClassName Student
 * @Description TODO
 * @Author yefeng
 * @Date 2021/4/17 21:02
 * @Version 1.0
 */
@Data
public class Student {
  private int id;
  private String name;
  private Teacher teacher;

}
