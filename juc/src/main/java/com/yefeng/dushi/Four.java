package com.yefeng.dushi;

import java.util.Arrays;

/**
 * @Author: 叶枫
 * @Date: 2025/04/11/17:48
 * @Description: 考察点: 数组
 */
public class Four {
    public static void main(String[] args) {
        int[] array = {-5, -4, -3, -2, -1, 0, 0, 1, 2, 3, 4, 5};
        test(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    // 不借助额外变量的经典“加减换位法”
    public static void test(int[] arr, int i, int j) {
        for (; i < j; i++, j--) {
            arr[i] += arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] -= arr[j];
        }
    }
}
