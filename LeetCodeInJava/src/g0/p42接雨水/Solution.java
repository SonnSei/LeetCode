package g0.p42接雨水;

import java.util.Stack;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/26 15:28
 * @Author SonnSei
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(nums));
    }

    public int trap(int[] height) {
        if(height==null || height.length<3)return 0;
        int left = 0,right = 1;
        int ret = 0;
        while (right < height.length) {
            while (right < height.length && height[right] < height[right - 1]) {
                right++;
            }

            if(right==height.length)break;
            int min = Math.min(height[left], height[right]);
            for (int i = left; i <right ; i++) {
                if (height[i] < min) {
                    ret+=min-height[i];
                    height[i] = min;
                }
            }
            if(height[right]>=height[left])
                left = right;
            right++;
        }
        return ret;
    }
}
