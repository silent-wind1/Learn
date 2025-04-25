package com.yefeng.structure.array;

/**
 * @Author: 叶枫
 * @Date: 2025/04/25/22:33
 * @Description:
 */
public class ArraysListTest {
    public static void main(String[] args) {
        ArraysList<Integer> list = new ArraysList<>();
        list.insert(3);
        list.insert(5);
        list.insert(6);
        list.insert(1, 7);
        list.delete(3);
        for (Integer data : list) {
            System.out.println(data);
        }
    }
}
