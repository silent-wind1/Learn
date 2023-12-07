package com.demo8;

import org.junit.Test;

import java.util.Random;

public class newInstanceTest {
    // 反射的动态性
    @Test
    public void test3() {
        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);
            String classPath = "";
            switch (num) {
                case 0: classPath = "java.util.Date";break;
                case 1: classPath = "java.lang.Object"; break;
                case 2: classPath = "com.demo8.ProxyTest"; break;
            }
            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    // 指定一个指定类的对象 classPath：指定类的全类名
    public Object getInstance(String classPath) {
        try {
            Class forName = Class.forName(classPath);
            return forName.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
