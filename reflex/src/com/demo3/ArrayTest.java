package com.demo3;

import java.io.File;
import java.util.*;

public class ArrayTest {
    public static void main(String[] args) {
        int[] s = new int[3];
        System.out.println(s[0]);
        String[] str = new String[3];
        str[1] = "德玛西亚";
        System.out.println(str[1]);
//      重新new相当于开辟了一个新单元
        str = new String[3];
        System.out.println(str[1]);
//        ArrayDemo();
        Test();
    }
    public static void ArrayDemo() {
        Scanner input = new Scanner(System.in);
        System.out.print("输入学生的个数:");
        int studentNumber = input.nextInt();
        int[] Student = new int[studentNumber];
        int max = 0;
        System.out.printf("输入%s学生的成绩%n", studentNumber);
        for (int i = 0; i < Student.length; i++) {
            Student[i] = input.nextInt();
            if (Student[i] > max) {
                max = Student[i];
            }
        }
        System.out.println("最高成绩为：" + max);

    }

    public static void Test() {
        int[][] array1 = new int[4][2];
        System.out.println(array1[0]);
        System.out.println(array1[0][1]);
        for (int[] ints : array1) {
            for (int i : ints) {
                System.out.print(i + ",");
            }
            System.out.println();
        }

        File file = new File("D:/BaiduNetdisk");
        System.out.println(file.isFile());

    }

}
