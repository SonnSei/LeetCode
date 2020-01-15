package p53最大子序和;

/**
 * @Classname Solution5
 * @Description
 * @Date 2020/1/14 10:39
 * @Author SonnSei
 */
public class Solution5 {
    /**
     * 线性的复杂度 O(n)
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            sum = sum > 0 ? sum + nums[i] : nums[i];
            max = max>sum?max:sum;
        }
        return max;
    }
}
