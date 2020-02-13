package g2.p215数组中的第K大元素;

import java.util.Arrays;

/**
 * @Classname Solution1
 * @Description 排序
 * @Date 2020/2/13 11:22
 * @Author SonnSei
 */
public class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length==0)return 0;
        int n = nums.length;
        if(k<1||k>n)return 0;
        Arrays.sort(nums);
        return nums[n - k];
    }
}
