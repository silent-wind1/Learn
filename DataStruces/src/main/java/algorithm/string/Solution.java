package main.java.algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String helloWorld = splitReverseWords("hello  world ");
        System.out.println(helloWorld);
        String helloWorld2 = reverseWords("Welcome to shenzhen");
        System.out.println(helloWorld2);
        String s = stringToUppercase(helloWorld2);
        System.out.println(s);
        System.out.println(stringToLowercase(s));
        List<String> string = splitString("hello world", ' ');
        for (String stringBuilder : string) {
            System.out.println(stringBuilder);
        }
    }

    /**
     * 双指针实现翻转字符串里的单词
     *
     * @param s 字符串
     * @return 翻转后的字符串
     */
    public static String reverseWords(String s) {
        // 去除首尾空格
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            // 找到第一个空格
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            // 添加单词
            sb.append(s, i + 1, j + 1).append(" ");
            // 跳过空格, 找到下一个单词的末尾
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            // j 指向下个单词的空格
            j = i;
        }
        return sb.toString().trim();
    }


    /**
     * 分隔 + 倒序实现翻转字符串里的单词
     *
     * @param s 字符串
     * @return 翻转后的字符串
     */
    public static String splitReverseWords(String s) {
        // 去除首尾空格
        String[] str = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        // 倒序遍历
        for (int i = str.length - 1; i >= 0; i--) {
            // 去除中间空格
            sb.append(str[i]);
            // 最后一个单词后不加空格
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * 将字符串中的小写字母转换为大写字母
     *
     * @param s 字符串
     * @return 转换后的字符串
     */
    public static String stringToUppercase(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                s = s.replace(s.charAt(i), (char) (s.charAt(i) - 32));
            }
        }
        return s;
    }

    /**
     * 将字符串中的大写字母转换为小写字母
     *
     * @param s 字符串
     * @return 转换后的字符串
     */
    public static String stringToLowercase(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                s = s.replace(s.charAt(i), (char) (s.charAt(i) + 32));
            }
        }
        return s;
    }

    /**
     * 将字符串按照给定的正则表达式进行分割
     *
     * @param str 字符串
     * @return 分割后的字符串数组
     */
    public static List<String> splitString(String str, char regex) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        List<String> list = new ArrayList<>();
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != regex) {
                stringBuilder.append(charAt);
            } else {
                list.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
            i++;
        }
        if (stringBuilder.length() > 0) {
            list.add(stringBuilder.toString());
        }
        return list;
    }
}
