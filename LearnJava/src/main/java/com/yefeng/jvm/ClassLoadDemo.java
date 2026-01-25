package com.yefeng.jvm;

/**
 * @author wind
 * @date 2026/1/9 14:06
 * @description:  类加载器的作用
 *          *  类加载器的作用：
 *          *  1.在运行时动态获取加载类，而不是一次性加载所有类对象，通过
 *          *  2.通过不同的类加载器，可以加载隔离同名类，使它们不会发生冲突
 */
public class ClassLoadDemo {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoadDemo.class.getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
    }
}
