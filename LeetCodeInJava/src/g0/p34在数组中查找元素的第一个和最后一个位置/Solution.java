package g0.p34在数组中查找元素的第一个和最后一个位置;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/24 19:48
 * @Author SonnSei
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
        if(nums==null || nums.length==0)return ret;
        int left = getLeftBorder(nums, target);
        if(left>=nums.length || nums[left]!=target)return ret;
        int right = getLeftBorder(nums, target + 1);
        return new int[]{left, right - 1};
    }

    private int getLeftBorder(int[] nums, int target) {
        int left=0,right=nums.length;
        while (left < right) {
            int mid = (left+right)>>>1;
            if(target<=nums[mid])
                right = mid;
            else
                left = mid+1;
        }
        return left;
    }
}
