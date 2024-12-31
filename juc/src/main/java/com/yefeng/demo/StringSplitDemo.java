package com.yefeng.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: 叶枫
 * @Date: 2024/12/30/12:32
 * @Description:
 */
public class StringSplitDemo {
    public static void main(String[] args) {
        String fb1 = ",1,14716,";
        // 使用正则表达式匹配数字
        String regex = "\\d+";
        List<Integer> numbers = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fb1);
        while (matcher.find()) {
            // 提取到的数字
            int number = Integer.parseInt(matcher.group());
            numbers.add(number);
        }
        // 输出数字列表
        System.out.println(numbers);

        List<String> lines = new ArrayList<>();
        lines.add("1");
        lines.add("2");
        lines.add("3");
        lines.add("4");
        System.out.println(lines.get(lines.size() - 2));


        System.out.println("bye 2024");

    }
}
