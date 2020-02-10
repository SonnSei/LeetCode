package g3.p300最长上升子序列;

import java.util.Arrays;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/10 10:57
 * @Author SonnSei
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length == 0)return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <i ; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int ret = dp[0];
        for (int val : dp) {
            ret = Math.max(ret, val);
        }
        return ret;
    }
}
