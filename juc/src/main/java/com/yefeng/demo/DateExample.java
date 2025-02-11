package com.yefeng.demo;

import java.util.Calendar;

public class DateExample {
    public static void main(String[] args) {
        // 获取当前日期的Calendar对象
        Calendar calendar = Calendar.getInstance();
        
        // 获取当前年份
        int year = calendar.get(Calendar.YEAR);
        
        // 获取当前月份（注意月份从0开始，所以需要加1）
        int month = calendar.get(Calendar.MONTH) + 1;
        
        System.out.println("Current Year: " + year);
        System.out.println("Current Month: " + month);
    }
}
