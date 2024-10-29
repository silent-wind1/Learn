package main.java.datastructure.soft;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 6, 3, 2, 1, 8, 3};
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quicksort(int[] arr, int left, int right) {
        int low = left;
        int high = right;
        int pivot = arr[(left + right) / 2];
        while (low < high) {
            // 在pivot的左边一直查找，找到大于等于pivot值，才退出
            while (arr[low] < pivot) {
                low++;
            }
            // 在pivot的右边一直查找，找到小于等于pivot值，才退出
            while (arr[high] > pivot) {
                high--;
            }
            if(low >= high) {
                break;
            }
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            if(arr[low] == pivot) {
                high--;
            }
            if(arr[high] == pivot) {
                low++;
            }
        }
        if(low == high) {
            low++;
            high--;
        }

        if(left < high) {
            quicksort(arr, left, high);
        }
        if(right > low) {
            quicksort(arr, low, right);
        }
    }
}
