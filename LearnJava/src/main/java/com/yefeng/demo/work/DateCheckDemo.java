package com.yefeng.demo.work;

import java.time.LocalDate;

public class DateCheckDemo {
    public static void main(String[] args) {
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();

        // 获取当前月的15号
        LocalDate fifteenthDay = currentDate.withDayOfMonth(15);

        // 判断当前日期是否在15号之前
        if (currentDate.isBefore(fifteenthDay)) {
            System.out.println("当前日期是15号之前");
        } else {
            System.out.println("当前日期是15号之后");
        }
    }
}
