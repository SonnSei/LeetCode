package g3.p378有序矩阵中第K小的元素;

import java.util.PriorityQueue;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/14 9:46
 * @Author SonnSei
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->b-a);
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                priorityQueue.add(row[i]);
                if(priorityQueue.size()>k)priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }
}
