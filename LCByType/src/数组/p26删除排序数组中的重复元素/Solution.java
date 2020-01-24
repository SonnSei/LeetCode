package 数组.p26删除排序数组中的重复元素;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/24 17:53
 * @Author SonnSei
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int left = 0,right = 0;
        while (right < nums.length) {
            while(right+1<nums.length&& nums[right]==nums[right+1])right++;
            swap(nums,left++,right++);
        }
        return left;
    }
    public static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
