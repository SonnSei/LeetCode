package g0;

import java.util.Arrays;

/**
 * @Classname Solution31
 * @Description 下一个排列
 * @Date 2020/1/7 10:18
 * @Author SonnSei
 */
public class Solution31 {
    public void nextPermutation(int[] nums) {
        int pos = -1;
        for (int i = nums.length-1; i >0 ; i--) {
            if (nums[i - 1] < nums[i]) {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            Arrays.sort(nums);
            return;
        }

        for (int i = nums.length-1; i >=pos ; i--) {
            if (nums[i] > nums[pos - 1]) {
                swap(nums, pos - 1, i);
                break;
            }
        }
        // 这个地方其实可以用reverse，但是这样写方便一点
        Arrays.sort(nums, pos, nums.length );

    }
    public static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
