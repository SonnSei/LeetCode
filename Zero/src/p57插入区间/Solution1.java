package p57插入区间;

import java.util.*;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/15 8:59
 * @Author SonnSei
 */
public class Solution1 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(newInterval == null || newInterval.length == 0)return intervals;
        if(intervals == null || intervals.length == 0) return new int[][]{newInterval};
        int[][] ret = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            ret[i] = intervals[i];
        }
        ret[intervals.length] = newInterval;
        Arrays.sort(ret,Comparator.comparingInt(a->a[0]));
        return merge(ret);
    }
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
