package g0.p35搜索插入位置;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/24 19:53
 * @Author SonnSei
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length==0)return -1;
        int left=0,right=nums.length-1;
        while (left <= right) {
            int mid = (left+right)>>>1;
            if(target<nums[mid])
                right = mid-1;
            else if(target>nums[mid])
                left=mid+1;
            else
                return mid;
        }
        return left;
    }
}
