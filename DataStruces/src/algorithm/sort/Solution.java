package algorithm.sort;

import java.util.Arrays;
import java.util.Vector;

/**
 * 数组中的第K个最大元素
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(array, 2));
        int fib = fib(10);
        System.out.println(fib);
    }

    /**
     * Arrays.sort(nums); 采用快速选择
     * @param nums 数组
     * @param k 下标
     * @return 值
     */
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num + "\t");
        }
        return nums[nums.length - k];
    }

    public int findKthLargest1(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    public int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = nums[left];
        int gt = left, lt = right, i = left;
        while (i <= lt) {
            if (nums[i] > pivot) swap(nums, gt++, i++);
            else if (nums[i] < pivot) swap(nums, i, lt--);
            else i++;
        }
        if (gt - 1 >= k) return quickSelect(nums, left, gt - 1, k);
        else if (lt + 1 <= k) return quickSelect(nums, lt + 1, right, k);
        return pivot;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static int fib(int  n) {
        if(n < 1) {
            return 0;
        }
        Vector<Integer> tmp = new Vector<>(n + 1);
        for (int i = 0; i <= n; i++) {
            tmp.add(0); // Fill the Vector with 0s
        }
        return helper(tmp, n - 1);
    }

    public static int helper(Vector<Integer> memo, int n) {
        // base case
        if (n == 1 || n == 2) {
            return 1;
        }
        // 已经计算过
        if (memo.get(n) != 0)  {
            return memo.get(n);
        }
        memo.set(n, helper(memo, n - 1) + helper(memo, n - 2));
        return memo.get(n);
    }
}
