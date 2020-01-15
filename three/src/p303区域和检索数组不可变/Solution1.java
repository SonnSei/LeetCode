package p303区域和检索数组不可变;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/14 23:33
 * @Author SonnSei
 */
public class Solution1 {

    class NumArray {
        int[] dp;

        public NumArray(int[] nums) {
            dp = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                dp[i] = dp[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return dp[i] - dp[j];
        }
    }

}
