package g3.p303区域检索数组不可变;

/**
 * @Classname Solution303
 * @Description 区域和检索 - 数组不可变
 * @Date 2019/12/20 10:24
 * @Author SunCheng
 */
public class Solution303 {

    class NumArray {
        int[] dp;
        public NumArray(int[] nums) {
            dp = new int[nums.length + 1];
            for (int i = 0; i <nums.length ; i++) {
                dp[i+1] = nums[i]+dp[i];
            }
        }

        public int sumRange(int i, int j) {
            return dp[j] - dp[i];
        }
    }
}
