package g0.p34在排序数组中查找元素的第一个和最后一个位置;

import java.util.Arrays;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/13 16:58
 * @Author SonnSei
 */
public class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        if (nums == null || nums.length == 0) return ret;
        int left = binarySearch(nums, target);
        // left是可能等于nums.lengt的
        if (left >= nums.length || nums[left] != target) return ret;
        int right = binarySearch(nums, target + 1);
        ret[0] = left;
        ret[1] = right - 1;
        // 也可以这么写
//        right = binarySearchR(nums, right);
//        ret[0] = left;
//        ret[1] = right;
        return ret;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (target <= nums[mid])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}
