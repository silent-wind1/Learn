package com.yefeng.prototype.demo;

/**
 * 原型模式： 奖状类
 */
public class Citaion implements Cloneable{

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void show() {
        System.out.println(student.getName() + "同学：您好获得2023年12月11日的好学生");
    }

    @Override
    public Citaion clone() throws CloneNotSupportedException {
        return (Citaion) super.clone();
    }



}
