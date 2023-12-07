package com.demo8;

import org.junit.Test;

import java.util.Random;

import static com.sun.deploy.ui.ImageLoader.getInstance;

public class ReflectionTest {
    public static void main(String[] args) {

    }

    @Test
    public void test1() {
        // 对于自定义类，使用系统类加载器进行加载
        ClassLoader loader = ReflectionTest.class.getClassLoader();
        System.out.println(loader);
        // 调用系统类加载器的getParent()方法：获取扩展类加载器
        ClassLoader parent = loader.getParent();
        System.out.println(parent);
        // 调用扩展类加载器的getParent()：无法获取引导类加载器
        // 引导类加载器主要负责加载java的核心类库，无法加载自定义类
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
    }

    @Test
    public void test2() throws InstantiationException, IllegalAccessException {
        // 反射基本使用
        Class<myReflection> aClass = myReflection.class;
        // newInstance() 调用缺省构造函数，返回一个Class实例
        myReflection re = aClass.newInstance();
        System.out.println(re
        );
        re.setName("yefeng");
        System.out.println(re.getName());
    }
}
// 定义一个实体类
class myReflection {
    private String name;
    private String age;

    public myReflection() {
    }

    public myReflection(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private void show() {
        System.out.println("我是一个私有方法");
    }

    @Override
    public String toString() {
        return "myReflection{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}