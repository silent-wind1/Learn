package com.demo3;

import java.util.Scanner;

public class HuiwenTest {
    public static void main(String[] args) {
        int[] s = new int[10];
        for (int i = 0; i < s.length; i++) {
            s[i] = (int) (Math.random() * 10 + 1);
            System.out.print(s[i] + "\t");
        }
    }
}
