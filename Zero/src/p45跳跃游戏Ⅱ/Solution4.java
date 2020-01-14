package p45跳跃游戏Ⅱ;

/**
 * @Classname Solution4
 * @Description
 * @Date 2020/1/14 9:48
 * @Author SonnSei
 */
public class Solution4 {
    public int jump(int[] nums) {
        int position = nums.length - 1; //要找的位置
        int steps = 0;
        while (position != 0) { //是否到了第 0 个位置
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) {
                    position = i; //更新要找的位置
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
