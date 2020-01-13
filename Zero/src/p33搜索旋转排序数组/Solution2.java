package p33搜索旋转排序数组;

import java.util.Arrays;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/13 16:54
 * @Author SonnSei
 */
public class Solution2 {
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)return -1;
        if(nums.length==1)return nums[0]==target?0:-1;
        int pos = findPos(nums);
        System.out.println(pos);
        if(target == nums[pos])return pos;
        if(pos==nums.length-1)return Math.max(Arrays.binarySearch(nums, 0, nums.length, target),-1);
        if(target<nums[0]) return Math.max(Arrays.binarySearch(nums, pos+1 , nums.length, target),-1);
        return Math.max(Arrays.binarySearch(nums, 0, pos+1, target),-1);
    }

    private static int findPos(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        if(nums[left]<nums[right])return right;
        while (left <= right) {
            int mid = (left+right)>>>1;
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            } else {
                if(nums[mid]<nums[left])
                    right=mid-1;
                else
                    left = mid+1;
            }
        }
        return 0;
    }
}
