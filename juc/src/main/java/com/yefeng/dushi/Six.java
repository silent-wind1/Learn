package com.yefeng.dushi;

/**
 * @Author: 叶枫
 * @Date: 2025/04/11/17:59
 * @Description: 用代码如何计算出来 A、B、C、D、E站一排照相，其中 A、B不能站正中间，有多少种站法;如果不能站两边，又有多少种?
 */
public class Six {
    static int countNotMiddle = 0;
    static int countNotEdges = 0;

    public static void main(String[] args) {
        String[] people = {"A", "B", "C", "D", "E"};

        permute(people, 0);
        // 72
        System.out.println("A、B不能站中间的排列数: " + countNotMiddle);
        // 36
        System.out.println("A、B不能站两边的排列数: " + countNotEdges);
    }

    // 全排列生成
    public static void permute(String[] arr, int index) {
        if (index == arr.length) {
            checkNotMiddle(arr);
            checkNotEdges(arr);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            permute(arr, index + 1);
            swap(arr, i, index); // 回溯
        }
    }

    // 判断中间不能是 A 或 B
    public static void checkNotMiddle(String[] arr) {
        String middle = arr[2]; // 中间是第3位
        if (!middle.equals("A") && !middle.equals("B")) {
            countNotMiddle++;
        }
    }

    // 判断两边不能是 A 或 B
    public static void checkNotEdges(String[] arr) {
        String left = arr[0];
        String right = arr[4];
        if (!left.equals("A") && !left.equals("B") && !right.equals("A") && !right.equals("B")) {
            countNotEdges++;
        }
    }

    // 交换元素
    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
