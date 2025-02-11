package main.java.algorithm.array;

/**
 * 合并两个有序数组
 */
public class mergeArray {
    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        int len1 = m - 1;
        int len2 = n - 1;
        while (len1 >= 0 && len2 >= 0) {
            nums1[len--] = nums1[len1] >= nums2[len2] ? nums1[len1--] : nums2[len2--];
        }

        for (int i : nums1) {
            System.out.print(i + "\t");
        }
    }
}
