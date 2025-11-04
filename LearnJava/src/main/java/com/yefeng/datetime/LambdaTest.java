package com.yefeng.datetime;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1002);
        list.add(800);
        list.add(300);
        list.add(1200);
        long sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        // 获取上个月第一天
        LocalDate firstDayOfLastMonth = LocalDate.now()
                .minusMonths(1)
                .withDayOfMonth(1);
        System.out.println("上个月第一天: " + firstDayOfLastMonth);

        // 获取上个月最后一天
        LocalDate lastDayOfLastMonth = LocalDate.now()
                .minusMonths(1)
                .with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("上个月最后一天: " + lastDayOfLastMonth);

        // 获取6个月前的第一天
        LocalDate firstDayOfSixMonthsAgo = LocalDate.now()
                .minusMonths(6)
                .withDayOfMonth(1);
        System.out.println("6个月前的第一天: " + firstDayOfSixMonthsAgo);
    }
}
