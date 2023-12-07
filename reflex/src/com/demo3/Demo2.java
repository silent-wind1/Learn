package com.demo3;

public class Demo2 {
    public static void main(String[] args) {
        int a = 1, b = 0;
        for (int i = 1; i <= 12; i++) {
            System.out.printf("第%d个月有多少%d兔子\n", i, a);
            b += a;
            i++;
            System.out.printf("第%d个月有%d兔子\n", i, b);
            a += b;
        }
        String num = new String("1234");
        StringBuilder s = null;
        System.out.println(s);
        System.out.println(num);
    }
}
