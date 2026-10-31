package com.yefeng.structure.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6, 3, 8, 7, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        // [1, 2, 3, 4, 5, 5, 6, 7, 8, 9]
    }

    /**
     * 归并排序（递归版）
     * 时间 O(n log n)，空间 O(n)，稳定
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int[] temp = new int[arr.length]; // 辅助数组只分配一次，避免递归里反复 new
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) {
            return; // 只剩一个元素，天然有序
        }
        int mid = left + (right - left) / 2; // 防溢出写法
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);

        // 优化：左右两段已经有序时，无需合并
        if (arr[mid] <= arr[mid + 1]) {
            return;
        }
        merge(arr, left, mid, right, temp);
    }

    /**
     * 合并 arr[left..mid] 和 arr[mid+1..right] 两个有序段
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;      // 左段指针
        int j = mid + 1;   // 右段指针
        int k = left;      // temp 指针

        // 两段都有元素时，取较小者
        while (i <= mid && j <= right) {
            // 用 <= 而不是 <，保证稳定性：相等时先取左段
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 左段剩余
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 右段剩余
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // 拷贝回原数组
        for (int p = left; p <= right; p++) {
            arr[p] = temp[p];
        }
    }


}