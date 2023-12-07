package com.demo9.test;

import com.demo9.pojo.Person;
import com.sun.net.httpserver.HttpServer;
import org.junit.Test;

import java.lang.reflect.Method;

public class MethodTest  {
    @Test
    public void test1() {
        Class<Person> clazz = Person.class;
        // getMethods(): 获取当前运行时类及其所有父类声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("***********************");
        // getDeclaredMethods(): 获取当前运行时类及声明的所有方法（不包含父类中声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
    }
}
