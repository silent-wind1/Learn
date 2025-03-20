package com.yefeng.demo;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal amountValue = new BigDecimal("1000");
        BigDecimal bigDecimal = new BigDecimal("3000");
        int i = amountValue.compareTo(bigDecimal);
        System.out.println(i);

        int startPage = Math.max(-3, 1);  // 起始页默认为1
        int pageSize = Math.max(0, 10);  // 每页大小默认为10
        System.out.println(startPage + "\n" + pageSize);
    }
}
