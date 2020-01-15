package p56合并区间;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/15 9:01
 * @Author SonnSei
 */
public class Solution1 {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int[] item:intervals)
            priorityQueue.add(item);
        ArrayList<int[]> list = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            int[] cur = priorityQueue.poll();
            if (!priorityQueue.isEmpty() && cur[1] >= priorityQueue.peek()[0]) {
                int[] next = priorityQueue.poll();
                // 注意这个 Math.max(next[1],cur[1])
                priorityQueue.add(new int[]{cur[0], Math.max(next[1],cur[1])});
            } else {
                list.add(cur);
            }
        }
        // 注意这个toArray的方法
        return list.toArray(new int[list.size()][2]);
    }
}
