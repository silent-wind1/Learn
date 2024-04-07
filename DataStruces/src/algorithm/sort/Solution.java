package algorithm.sort;

import java.util.Arrays;

/**
 * 数组中的第K个最大元素
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(array, 2));
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
}
