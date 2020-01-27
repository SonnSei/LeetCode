package 数组.p53最大子序和;

/**
 * @Classname Solution3
 * @Description
 * @Date 2020/1/27 9:19
 * @Author SonnSei
 */
public class Solution3 {
    public int maxSubArray(int[] nums) {
        int tmp = nums[0];
        int ret = tmp;
        for (int i = 1; i <nums.length ; i++) {
            if (tmp > 0) {
                tmp += nums[i];
            } else {
                tmp = nums[i];
            }
            ret = Math.max(ret, tmp);
        }
        return ret;
    }
}
