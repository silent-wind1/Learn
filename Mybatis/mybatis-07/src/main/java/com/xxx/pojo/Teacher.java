package com.xxx.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {
  private int id;
  private String name;
//  一个老师有多个学生
  private List<Student> students;
}
