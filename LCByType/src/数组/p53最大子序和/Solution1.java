package 数组.p53最大子序和;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/27 8:32
 * @Author SonnSei
 */
public class Solution1 {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <sum.length ; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int ret = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = i; j <=nums.length ; j++) {
                int tmp = sum[j]-sum[i-1];
                ret = Math.max(tmp, ret);
            }
        }
        return ret;
    }
}
