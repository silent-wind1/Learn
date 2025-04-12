package com.yefeng.str;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 叶枫
 * @Date: 2025/04/12/13:22
 * @Description:  字符串对象的创建方式和比较方式的区别
 */
public class StringDemo1 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = new String("hello");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3.equals(s4));


        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.forEach((key, value) -> {
            if(key.equals("2")) {
                map.remove(key);
            }
        });
        System.out.println(map.size());
    }
}
