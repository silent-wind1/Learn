package com.yefeng.bishi.dushi;

/**
 * @Author: 叶枫
 * @Date: 2025/04/11/17:13
 * @Description: 笃实科技笔试题第五题, 考察点: 值传递
 */
public class Five {
    public static void main(String[] args) {
        int x = 10;
        tripleValue(x);
        System.out.println(x);

        int[] y ={10};
        tripleValue(y);
        System.out.println(y[0]);

        Person person = new Person();
        tripleValue(person);
        System.out.println(person.age);
    }

    static void tripleValue(int x) {
        x = x * 3; // 修改x的值
    }

    static void tripleValue(int[] x) {
        x[0] = x[0] * 3; // 修改x的值
    }

    /**
     *
     * @param x
     */
    static void tripleValue(Person x) {
        x = new Person();
       x.age = x.age * 3;
    }

    static class Person {
        private int age = 20;
    }
}
