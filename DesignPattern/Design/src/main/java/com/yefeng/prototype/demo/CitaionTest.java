package com.yefeng.prototype.demo;

public class CitaionTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citaion citaion = new Citaion();
        Student stu = new Student("思凯", "西安");
        citaion.setStudent(stu);

        Citaion citaion1 = citaion.clone();
        Student student = citaion1.getStudent();

        student.setName("欧阳");

        //判断stu对象和stu1对象是否是同一个对象
        System.out.println("stu和stu1是同一个对象？" + (stu == student));
        citaion1.show();
        citaion.show();
    }
}
