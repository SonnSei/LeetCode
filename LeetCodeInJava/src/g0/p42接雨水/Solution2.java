package g0.p42接雨水;

import java.util.Stack;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/26 16:15
 * @Author SonnSei
 */
public class Solution2 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution2().trap(nums));
    }

    public int trap(int[] height) {
        if(height==null || height.length<3)return 0;
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        maxLeft[0] = height[0];
        maxRight[n - 1] = height[n - 1];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        for (int i = n-2; i >=0 ; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        int ret = 0;
        for (int i = 1; i <n-1 ; i++) {
            ret += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return ret;
    }
}
