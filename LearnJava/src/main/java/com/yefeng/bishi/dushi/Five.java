package com.yefeng.bishi.dushi;

/**
 * @Author: 叶枫
 * @Date: 2025/04/11/17:13
 * @Description: 笃实科技笔试题第五题, 考察点: 值传递
 */
public class Five {
    public static void main(String[] args) {
        int x = 10;
        tripleValue(x);
        System.out.println(x);
    }

    static void tripleValue(int x) {
        x = x * 3; // 修改x的值
    }
}
