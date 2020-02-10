package g3.p300最长上升子序列;

import java.util.Arrays;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/2/10 11:04
 * @Author SonnSei
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int len = 1;
        for (int i = 1; i <nums.length ; i++) {
            int index = Arrays.binarySearch(dp, 0, len, nums[i]);
            if(index<0)index = -index-1;
            dp[index] = nums[i];
            if(index==len)len++;
        }
        return len;
    }
}
