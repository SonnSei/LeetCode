package g0.p55跳跃游戏;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/27 10:03
 * @Author SonnSei
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length==0)return false;
        if(nums.length==1)return true;

        boolean[] visited = new boolean[nums.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;
            int move = nums[cur];
            if(cur+move>=nums.length-1)return true;
            for (int i = 0; i <=move ; i++) {
                if(!visited[cur+i]) queue.add(cur + i);
            }
        }
        return false;
    }
}
