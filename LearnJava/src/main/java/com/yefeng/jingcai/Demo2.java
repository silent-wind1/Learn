package com.yefeng.jingcai;

/**
 * @Author: 叶枫
 * @Date: 2025/04/22/20:56
 * @Description:
 */
public class Demo2 {
    public static void main(String[] args) {
        // 常量池中的字符串
        String str = "Hello World";
        // "Hello" 是常量池，new String("World") 是堆内对象
        // 整个拼接在运行时进行，最终是一个堆上的新对象，不会进入常量池
        String str2 = "Hello" + new String("World");
        System.out.println(str == str2);
        // 其实是调用静态方法 Demo2.test()，不会报错，正常输出 "Hello World"。
        ((Demo2) null).test();
    }

    // 静态方法，属于类
    private static void test() {
        System.out.println("Hello World");
    }
}
