package p11盛水最多的容器;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/11 6:29
 * @Author SonnSei
 */
public class Solution1 {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int tmp = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(tmp, max);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }
}
