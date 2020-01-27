package 数组.p53最大子序和;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/27 8:44
 * @Author SonnSei
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        int ret = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = i; j <nums.length ; j++) {
                tmp+=nums[j];
                ret = Math.max(tmp, ret);
            }
        }
        return ret;
    }
}
