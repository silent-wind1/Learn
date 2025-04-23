package com.yefeng.bishi.dushi;

/**
 * @Author: 叶枫
 * @Date: 2025/04/11/18:04
 * @Description: 笃实科技笔试题第七题, 考察点: 数组
 */
public class Seven {
    public static void main(String[] args) {
        run(5);
    }

    private static void run(int x) {
        int[][] arr = new int[x][x];
        int num = 1;
        for (int row = 0; row < arr.length; row++) {
            for (int i = row, col = 0; i >= 0; i--) {
                arr[i][col++] =  num++;
            }
        }
        for (int[] aryItem : arr) {
            for (int value : aryItem) {
                if (value != 0) {
                    System.out.print(value + "\t");
                }
            }
            System.out.println();
        }
    }
}
