package g0.p11盛水最多的容器;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/24 16:29
 * @Author SonnSei
 */
public class Solution {
    public int maxArea(int[] height) {
        if(height==null || height.length<2)return 0;
        int max = 0;
        int left=0,right = height.length-1;
        int tmp;
        while (left < right) {
            tmp = (right-left)*Math.min(height[left], height[right]);
            max = Math.max(max, tmp);
            if(height[left]<height[right])left++;
            else right--;
        }
        return max;
    }
}
