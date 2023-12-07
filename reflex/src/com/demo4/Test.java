package com.demo4;

public class Test {
    public static void main(String[] args) {
        Student student = new Student("yefeng", "女", "18");
        System.out.println(student.toString());
        student.setName("yuling");
        System.out.println(student.getName());
    }
}
