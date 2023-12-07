package com.demo5;

public class Student extends School{
    public Student(String name, String sex, String age){
        super(name, sex, age);
    }

    public static void main(String[] args) {
        Student student = new Student("1", "2", "3");
        student.My();
    }
}
