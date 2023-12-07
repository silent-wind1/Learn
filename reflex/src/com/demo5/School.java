package com.demo5;

public class School {
    private String name, sex, age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public School() {
    }

    public School(String name, String sex, String age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }


    public void My() {
        System.out.println("我是" + this.name + "我的性别是" + this.sex + "我的年龄" + this.age);
    }
}
