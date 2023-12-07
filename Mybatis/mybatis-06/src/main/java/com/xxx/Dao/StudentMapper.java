package com.xxx.Dao;

import com.xxx.pojo.Student;

import java.util.List;

public interface StudentMapper {
//  查询所有的学生信息，通过学生查找到对应的老师信息
  List<Student> getStudent();
  List<Student> getStudent2();
}
