package g0.p81搜索旋转排序数组Ⅱ;

import java.util.Arrays;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/17 8:41
 * @Author SonnSei
 */
public class Solution1 {
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0)return false;
        if(nums.length==1)return nums[0]==target;
        int pos = findPos(nums);
        if(target>=nums[0]) return Arrays.binarySearch(nums, 0, pos+1,target) >= 0;
        return  Arrays.binarySearch(nums,pos+1, nums.length, target )>=0;
    }

    private static int findPos(int[] nums) {
        int left = 0,right = nums.length-1;
        while (left <= right) {
            // 避免死循环
            int mid = (left+right+1)>>>1;
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                while(left<right && nums[left+1]>=nums[left])left++;
                return left;
            }
            if (mid== left) {
                return left;
            }
            // 首先，当中值大于左值时，移动left到mid是没有问题的，
            // 等于的时候其实是有问题的，但是只有左值==中值==右值的时候有问题，而这种情况已经在之前处理了，所以这里可以加上等于
            if(nums[mid]>=nums[left])
                left = mid;
            else
                right = mid-1;
        }
        return left;
    }
}
