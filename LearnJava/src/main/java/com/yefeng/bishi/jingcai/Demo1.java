package com.yefeng.bishi.jingcai;

/**
 * @Author: 叶枫
 * @Date: 2025/04/22/21:11
 * @Description: 从 1~100 的连续整数中 随机删除一个数，现在给你剩下的 99 个数，问：如何快速找出被删掉的数字？
 */
public class Demo1 {
    public static void main(String[] args) {
        // 方法一：数学法（推荐，最快）
        // 示例：删除了 42
        int[] nums = new int[99];
        int index = 0;
        for (int i = 1; i <= 100; i++) {
            if (i == 42) continue;
            nums[index++] = i;
        }

        System.out.println("缺失的数字是: " + findMissing(nums));


    }

    /**
     * 数学法（推荐，最快）
     * 1 + 2 + 3 + ... + 100 的和是一个确定的值（等差数列求和）
     * 把剩下的 99 个数求和
     * 两者一减，就得到了缺失的那个数
     *
     * @param nums
     * @return
     */
    public static int findMissing(int[] nums) {
        int n = 100;
        int total = n * (n + 1) / 2; // 1~100 的和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return total - sum;
    }


    /**
     * 异或法（进阶理解）
     * 对 1~100 做一次异或，得到结果 A
     * 对剩下的 99 个数做一次异或，得到结果 B
     * 缺失的数就是：A ^ B
     *
     * @param nums
     * @return
     */
    public static int findMissingXOR(int[] nums) {
        int xorAll = 0, xorPart = 0;
        for (int i = 1; i <= 100; i++) {
            xorAll ^= i;
        }
        for (int num : nums) {
            xorPart ^= num;
        }
        return xorAll ^ xorPart;
    }

}
