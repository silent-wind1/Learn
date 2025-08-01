package main.java.algorithm.array;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        rotate(matrix);
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix.length; j++) {
//                System.out.print(matrix[i][j] + "\t");
//            }
//            System.out.println();
//        }

        int i = removeDuplicates(new int[]{1, 1, 1, 1, 2, 2, 3, 3, 3, 4});
        System.out.println(i);

        System.out.println(reverse(-2147483648));
    }

    /**
     * 旋转矩阵
     *
     * @param matrix 矩阵
     */
    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                exchange(matrix, i, j, j, matrix.length - 1 - i);
                exchange(matrix, i, j, matrix.length - 1 - i, matrix.length - 1 - j);
                exchange(matrix, i, j, matrix.length - 1 - j, i);
            }
        }
    }

    /**
     * 交换矩阵元素
     *
     * @param matrix 矩阵
     * @param i1
     * @param j1
     * @param i2
     * @param j2
     */
    public static void exchange(int[][] matrix, int i1, int j1, int i2, int j2) {
        matrix[i1][j1] = matrix[i1][j1] + matrix[i2][j2];
        matrix[i2][j2] = matrix[i1][j1] - matrix[i2][j2];
        matrix[i1][j1] = matrix[i1][j1] - matrix[i2][j2];
    }

    /**
     * 移除元素
     *
     * @param nums 数组
     * @param val  删除的值
     * @return 删除后的数组长度
     */
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    /**
     * 删除排序数组中的重复项
     *
     * @param nums 数组
     * @return 数组长度
     */
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int slow = 1, fast = 1;
        while (fast < n) {
            // 判断当前值是否和前一个值相等
            if (nums[fast] != nums[fast - 1]) {
                // 不相等则赋给slow
                nums[slow++] = nums[fast];
            }
            // 相等直接移动fast
            ++fast;
        }
        return slow;
    }

    /**
     * 删除重复元素
     *
     * @param nums 数组
     * @return 数组长度
     */
    public int removeDuplicates1(int[] nums) {
        int j = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[j - 2] != nums[i]) {
                nums[j] = nums[i];
                ++j;
            }
        }
        return j;
    }

    /**
     * 判断括号是否有效
     *
     * @param s 字符串
     * @return
     */
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 回文数
     * @param x 数字
     * @return boolean
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int target = x;
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            res = res * 10 + tmp;
            x /= 10;

        }
        return res == target;
    }

    /**
     * 整数反转
     * @param x 数值
     * @return 反转后的值
     */
    public static int reverse(int x) {
        int sum = 0;
        while(x != 0) {
            int pop = x % 10;
            // 判断是否溢出最大值 2147483647
            if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && pop > 7)){
                return 0;
            }
            // 判断是否溢出最小值 -2147483648
            if (sum < Integer.MIN_VALUE / 10 || (sum == Integer.MIN_VALUE / 10 && pop < -8)){
                return 0;
            }
            sum = sum * 10 + pop;
            x = x / 10;
        }
        return sum;
    }

}



