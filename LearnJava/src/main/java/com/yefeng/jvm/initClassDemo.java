package com.yefeng.jvm;

/**
 * @Author: 叶枫
 * @Date: 2024/12/24/13:17
 * @Description:
 */
public class initClassDemo {
    public static int value = 24;

    static {
        value = 25;
    }

    public static void main(String[] args) {
        /**
         *  0 bipush 24
         *  2 putstatic #13 <com/yefeng/jvm/initClassDemo.value : I>
         *  5 bipush 25
         *  7 putstatic #13 <com/yefeng/jvm/initClassDemo.value : I>
         *  10 return
         *
         * 1.加载initClassDemo类
         * 2.执行initClassDemo类的static块，将value赋值为25
         * 3.执行main方法，将value赋值为24
         * 4.输出value的值
         * 5.程序结束
         */
        System.out.println(initClassDemo.value);
    }
}
