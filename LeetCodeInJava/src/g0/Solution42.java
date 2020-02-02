package g0;

import java.util.Stack;

/**
 * @Classname Solution42
 * @Description Trapping Rain Water
 * @Date 2019/12/14 12:55
 * @Created by SunCheng
 */
public class Solution42 {
    public static void main(String[] args) {
        int[] height = {2,0,2};
        System.out.println(new Solution42().trap3(height));
    }

    /**
     * 中心扩展
     * 时间复杂度：O(n^2)
     * 对于每一点，其最终的价值决定于Math.min(maxLeft,maxRight)
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int ret = 0;
        for (int i = 1; i <height.length-1 ; i++) {
            int mid = height[i];
            int maxLeft=0,maxRight = 0;
            for (int j = i; j >=0 ; j--) {
                maxLeft = Math.max(height[j], maxLeft);
            }
            for (int j = i; j <height.length ; j++) {
                maxRight = Math.max(height[j], maxRight);
            }
            int diff = Math.min(maxLeft, maxRight)-mid;
            if(diff>=0)ret+=diff;
        }
        return ret;
    }

    /**
     * 动态规划
     * 记录maxLeft与maxRight
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        // 合法性判断
        if (height == null || height.length < 3) return 0;

        // 初始化动态规划数组
        int[] maxLefts = new int[height.length];
        maxLefts[0] = height[0];
        int[] maxRights = new int[height.length];
        maxRights[maxRights.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            maxLefts[i] = Math.max(maxLefts[i - 1], height[i]);
        }
        for (int j = height.length - 2; j >= 0; j--) {
            maxRights[j] = Math.max(maxRights[j + 1], height[j]);
        }

        // 求解
        int ret = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int diff = Math.min(maxLefts[i], maxRights[i])-height[i];
            ret+=diff;
        }
        return ret;
    }


    /**
     * 栈的应用
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        if (height == null || height.length < 3) return 0;

        int ret = 0,current = 0;
        Stack<Integer> stack = new Stack<>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = current-stack.peek()-1;
                int boundedHeight = Math.min(height[current], height[stack.pop()] - height[top]);
                ret += distance*boundedHeight;
            }
            stack.push(current++);
        }
        return ret;
    }

    /**
     * 双指针
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     * @param height
     * @return
     */
    public int trap4(int[] height) {
        if (height == null || height.length < 3) return 0;
        int left = 0,right = height.length-1;
        int ret = 0;
        int maxLeft = 0,maxRight = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    ret += (maxLeft - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    ret += maxRight - height[right];
                }
                --right;
            }
        }
        return ret;
    }
}
