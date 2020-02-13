package g2.p215数组中的第K大元素;

import java.util.PriorityQueue;

/**
 * @Classname Solution
 * @Description 优先队列
 * @Date 2020/2/13 11:47
 * @Author SonnSei
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int val : nums) {
            priorityQueue.add(val);
            if(priorityQueue.size()>k)priorityQueue.poll();
        }
        return priorityQueue.poll();
    }
}
