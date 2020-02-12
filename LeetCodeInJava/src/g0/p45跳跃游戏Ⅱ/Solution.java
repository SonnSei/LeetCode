package g0.p45跳跃游戏Ⅱ;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/26 18:19
 * @Author SonnSei
 */
public class Solution {
    public int jump(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        // 注意这里返回的是  nums.length-1
        if(nums.length<3)return nums.length-1;
        int phaseEnd = 0;
        int maxR = 0;
        int ret = 0;
        // 注意 i < nums.length-1
        for (int i = 0; i < nums.length-1; i++) {
            maxR = Math.max(maxR, nums[i] + i);
            if (i == phaseEnd) {
                ret++;
                phaseEnd = maxR;
            }
        }
        return ret;
    }
}
