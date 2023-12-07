package com.demo6;

public class BubbleSortTest {
    public static void main(String[] args) {
//        冒泡排序
        int[] number = {9, 8, 2, 7, 1, 4, 6, 5, 0};
        for (int i = 0; i < number.length - 1; i++) {
            for (int j = 0; j < number.length - i - 1; j++) {
                if (number[j] > number[j + 1]) { // 降序
                    int temp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i] + "\t");
        }
    }
}
