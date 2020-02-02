package g0.p31下一个排列;

import java.util.Arrays;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/24 18:26
 * @Author SonnSei
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {5,4,7,5,3,2};
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length==0)return;
        int index = -1;
        for (int i = nums.length-1; i >0 ; i--) {
            if (nums[i - 1] < nums[i]) {
                index = i-1;
                break;
            }
        }
        if (index == -1) {
            reverse(nums,0,nums.length-1);
            return;
        }
        for (int i = nums.length-1; i >index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums,i,index);
                break;
            }
        }
        reverse(nums, index + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        for (int i = 0; i < (right-left+1)/2; i++) {
            swap(nums,i+left,right-i);
        }
    }

    public static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
