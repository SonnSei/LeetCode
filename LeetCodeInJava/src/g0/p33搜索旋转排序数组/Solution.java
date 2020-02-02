package g0.p33搜索旋转排序数组;

import java.util.Arrays;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/24 19:24
 * @Author SonnSei
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(new Solution().search(nums,0));
    }

    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0)return -1;
        int mid = getMid(nums);
        int ret = -1;
        if (nums[0] <= target) {
            ret = Arrays.binarySearch(nums,  0, mid + 1,target);
        } else {
            ret = Arrays.binarySearch(nums, mid + 1, nums.length,target);
        }
        if (ret < 0) ret = -1;
        return ret;
    }

    // 如果没有旋转点，我们设计的是返回最右侧元素
    private int getMid(int[] nums) {
        int left=0,right=nums.length-1;
        while (left < right) {
            int mid = (left+right+1)>>>1;
            // 当nums[mid]>nums[left]的时候，mid位置元素尚未被排除在搜索区间外
            if(nums[mid]>nums[left])
                left = mid;
            else
                right = mid-1;
        }
        return left;
    }
}
