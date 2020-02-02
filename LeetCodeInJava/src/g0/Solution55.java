package g0;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Solution55
 * @Description TODO
 * @Date 2020/1/2 14:25
 * @Author SonnSei
 */
public class Solution55 {
    public static void main(String[] args) {

    }
    public static boolean canJump3(int[] nums) {
        if(nums == null || nums.length==0)return false;
        if(nums.length == 1)return true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int right = 0;
        while(!queue.isEmpty()){
            int index = queue.poll();
            int move = nums[index];
            if(index+move>=nums.length-1)return true;
            if(index+move>right){
                for(int i = right;i<=index+move;i++){
                    queue.add(i);
                }
                right = index+move;
            }
        }
        return false;
    }


    public boolean canJump2(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

    boolean[] visited;
    public boolean canJump(int[] nums) {
        if(nums==null|| nums.length==0)return false;
        visited = new boolean[nums.length];
        return recursion(nums,0);
    }

    private boolean recursion(int[] nums, int start) {
        if(start+nums[start]>=nums.length-1)return true;
        if(visited[start])return false;
        visited[start] = true;
        boolean ret = false;
        for (int i = 1; i <= nums[start]; i++) {
            if(recursion(nums,start+i))ret = true;
        }
        return ret;
    }
}
