package p45跳跃游戏Ⅱ;

/**
 * @Classname Solution3
 * @Description
 * @Date 2020/1/13 23:10
 * @Author SonnSei
 */
public class Solution3 {
    public int jump(int[] nums) {
        int cnt = 0;
        int maxR = 0;
        int end = 0;
        for (int i = 0; i < nums.length-1; i++) {
            int move = nums[i];
            maxR = Math.max(maxR, nums[i] + i);
            if (i == end) {
                end = maxR;
                cnt++;
            }
        }
        return cnt;
    }
}
