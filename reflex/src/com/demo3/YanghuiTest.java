package com.demo3;

public class YanghuiTest {
    public static void main(String[] args) {
        int[][] yanghui = new int[10][10];
        for (int i = 0; i < yanghui.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    yanghui[i][j] = 1;
                } else {
                    yanghui[i][j] = yanghui[i - 1][j - 1] + yanghui[i - 1][j];
                }
                System.out.print(yanghui[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
