package com.yefeng.bishi.jingcai;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: 叶枫
 * @Date: 2025/04/22/21:13
 * @Description: 如果上题改为在 1~100 的一堆数字里(允许重复)，如何找出1~100 范围内缺失的数字?
 */
public class Demo3 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 5, 99, 100, 1, 50, 60}; // 示例测试
        List<Integer> missing = findMissing(arr);
        System.out.println("缺失的数字有：" + missing);

        List<Integer> missingWithSet = findMissingWithSet(arr);
        System.out.println("缺失的数字有" + missingWithSet);
    }

    /**
     * 布尔桶（最直观）
     * 创建一个长度为 100 的布尔数组 seen[100]，用来记录哪些数字出现过。
     * 遍历原数组，遇到 num，就设置 seen[num - 1] = true
     * 最后再扫一遍 seen[]，所有为 false 的下标 + 1，就是缺失的数字
     * @param nums
     * @return
     */
    public static List<Integer> findMissing(int[] nums) {
        boolean[] seen = new boolean[100]; // 1~100 -> index 0~99

        for (int num : nums) {
            if (num >= 1 && num <= 100) {
                seen[num - 1] = true;
            }
        }

        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (!seen[i]) {
                missing.add(i + 1);
            }
        }
        return missing;
    }


    /**
     * Set 去重检测（空间更多）
     * 用 HashSet<Integer> 收集所有出现过的值（自动去重）
     * 再遍历 1~100 看哪些没出现在 Set 中，就是缺失的
     *
     * @param nums
     * @return
     */
    public static List<Integer> findMissingWithSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num >= 1 && num <= 100) {
                set.add(num);
            }
        }

        List<Integer> missing = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (!set.contains(i)) {
                missing.add(i);
            }
        }
        return missing;
    }

}
