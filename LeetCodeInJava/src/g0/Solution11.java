package g0;

/**
 * @Classname Solution11
 * @Description 盛水最多的容器
 * @Date 2019/12/14 15:24
 * @Created by SunCheng
 */
public class Solution11 {

    /**
     * 双指针
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if(height == null || height.length<2)return 0;
        int left = 0,right = height.length-1;
        int ret = 0;
        while (left < right) {
            int distance = right-left;
            if (height[left] < height[right]) {
                ret = Math.max(ret, distance * height[left]);
                left++;
            } else {
                ret = Math.max(ret, distance * height[right]);
                right--;
            }
        }
        return ret;
    }

    /**
     * 暴力法
     * 时间复杂度：O（n^2）
     * 空间复杂度：O（1）
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        if(height == null || height.length<2)return 0;
        int ret = 0;
        for (int i = 1; i <height.length ; i++) {
            for (int j = 0; j < i; j++) {
                ret = Math.max(ret, Math.min(height[i], height[j]) * (i - j));
            }
        }
        return ret;
    }

}
