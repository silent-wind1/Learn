package com.demo3;

public class ArrayReversal {
    public static void main(String[] args) {
        String[] arr = {"AA", "BB", "CC", "DD", "EE"};
        System.out.println("反转前");
        for (String ar : arr) {
            System.out.print(ar + "\t");
        }
        // 数组反转操作
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        System.out.println("\n反转后");
        for (String ar : arr) {
            System.out.print(ar + "\t");
        }


        String find = "BB";
        boolean isFlag = true;
        for (int i = 0; i < arr.length; i++) {
            if (find.equals(arr[i])) {
                System.out.println("已经找到了下标为:" + i);
                isFlag = false;
            }
        }
        if (isFlag) {
            System.out.println("没有找到");
        }


        // 二分查找法
        int[] arraySearch = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        int search = 8, low = 0, hid = arraySearch.length - 1;
        boolean Flag = true;
        while (low < hid) {
            int mid = (low + hid) / 2;
            if(arraySearch[mid] == search) {
                System.out.println("找到了索引位置为：" + mid);
                Flag = false;
                break;
            } else if(arraySearch[mid] > search) {
                hid = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        if(Flag) {
            System.out.println("没有找到");
        }
    }
}
