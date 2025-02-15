package com.yefeng.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        // 获取当前日期
        LocalDate currentDate = LocalDate.now();

        // 获取当前年份
        int year1 = currentDate.getYear();

        // 获取当前月份
        int month1 = currentDate.getMonthValue();  // 返回的是1-12之间的月份

        System.out.println("Current Year: " + year1);
        System.out.println("Current Month: " + month1);


        // 使用Java日期API进行解析和计算
        String taxYear = "2024";
        String taxMonth = "03";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        LocalDate lastMonth = LocalDate.of(Integer.parseInt(taxYear), Integer.parseInt(taxMonth), 1);
        LocalDate currentMonth = lastMonth.plusMonths(1);
        String datetime = currentMonth.format(formatter);
        System.out.println(datetime);



    }
}
