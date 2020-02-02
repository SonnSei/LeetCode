package g0.p55跳跃游戏;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/27 10:10
 * @Author SonnSei
 */
public class Solution2 {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length==0)return false;
        int maxR = 0;
        for (int i = 0; i <nums.length ; i++) {
            if(i>maxR)break;
            maxR = Math.max(i + nums[i], maxR);
            if(maxR>=nums.length-1)return true;
        }
        return false;
    }
}
