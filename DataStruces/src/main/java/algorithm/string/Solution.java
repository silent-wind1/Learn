package main.java.algorithm.string;

public class Solution {
    public static void main(String[] args) {
        String helloWorld = splitReverseWords("hello  world ");
        System.out.println(helloWorld);
        String helloWorld2 = reverseWords("Welcome to shenzhen");
        System.out.println(helloWorld2);
    }

    /**
     * 双指针实现翻转字符串里的单词
     * @param s 字符串
     * @return 翻转后的字符串
     */
    public static String reverseWords(String s) {
        // 去除首尾空格
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder sb = new StringBuilder();
        while(i >= 0) {
            // 找到第一个空格
            while(i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            // 添加单词
            sb.append(s, i + 1, j + 1).append(" ");
            // 跳过空格, 找到下一个单词的末尾
            while(i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            // j 指向下个单词的空格
            j = i;
        }
        return sb.toString().trim();
    }


    /**
     * 分隔 + 倒序实现翻转字符串里的单词
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
}
