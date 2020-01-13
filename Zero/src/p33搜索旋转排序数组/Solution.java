package p33搜索旋转排序数组;

import java.util.Arrays;

/**
 * @Classname Solution
 * @Description 搜索旋转排序数组
 * @Date 2020/1/13 2:12
 * @Author SonnSei
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 3};
        System.out.println(search(nums, 3));
    }

    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)return -1;
        if(nums.length==1)return nums[0]==target?0:-1;
        int pos = findPos(nums);
        System.out.println(pos);
        if(target == nums[pos])return pos;
        if(pos==0)return Math.max(Arrays.binarySearch(nums, 0, nums.length, target),-1);
        if(target<nums[0]) return Math.max(Arrays.binarySearch(nums, pos , nums.length, target),-1);
        return Math.max(Arrays.binarySearch(nums, 0, pos, target),-1);
    }

    private static int findPos(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        if(nums[left]<nums[right])return 0;
        while (left <= right) {
            int mid = (left+right)>>>1;
            if (nums[mid] > nums[mid + 1]) {
                // 为什么return mid不可以？其余的地方也改了逻辑
                // mid+1代表的是新数组的开始，如果数组没有旋转，0也是有正确意义的
                // mid代表的是数组的结束，如果数组没有旋转，就不应该返回0
                return mid+1;
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
