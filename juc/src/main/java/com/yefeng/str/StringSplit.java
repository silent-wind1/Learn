package com.yefeng.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 叶枫
 * @Date: 2025/02/04/14:07
 * @Description:
 */
public class StringSplit {
    public static void main(String[] args) {
        splitString("1&&2&&3&&4&&5&&&3s");
    }

    public static void splitString(String msg) {
        String delimiter = "&&";
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        int endIndex = msg.indexOf(delimiter);

        while (endIndex != -1) {
            result.add(msg.substring(startIndex, endIndex));
            startIndex = endIndex + delimiter.length();
            endIndex = msg.indexOf(delimiter, startIndex);
        }

        result.add(msg.substring(startIndex)); // 添加最后一个部分
        String[] array = result.toArray(new String[0]);
        System.out.println(Arrays.toString(array));
        joinString(array);
    }

    public static void joinString(String[] array){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length - 1; i++) {
            result.append(array[i]).append("&&");
        }
        result.append(array[array.length - 1]);
        System.out.println(result);
    }

    public static void joinString2(String[] array) {
        System.out.println(Arrays.stream(array).collect(Collectors.joining("&&")));
    }

}
