package main.java.datastructure.array;

/**
 * 中心下标
 */
public class MidIndex {
    public static void main(String[] args) {
//        int[] num = {1,7,3,6,5,6};
//        int i = pivotIndex(num);
//        System.out.println(i);


        int[] nums = {1, 2, 3, 4, 5, 6};
        int item = 2;
        System.out.println(binary_search(nums, item));
    }


    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int left_num = 0;
        for (int i = 0; i < nums.length; i++) {
            if(left_num == (sum - left_num - nums[i])) {
                return i;
            }
            left_num += nums[i];
        }
        return -1;
    }

    /**
     * 二分查找
     * @param nums 数组
     * @param item 查找的值
     * @return 查找到返回数组下标，否则返回 -1
     */
    public static int binary_search(int[] nums, int item) {
        if(nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == item) {
                return item;
            }else if (nums[mid] > item) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
