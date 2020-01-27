package 数组.p57插入区间;

import java.util.LinkedList;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/27 10:31
 * @Author SonnSei
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> list = new LinkedList<>();
        if(intervals==null || newInterval==null)return list.toArray(new int[0][]);
        int i = 0;
        while (i < intervals.length&&intervals[i][1]<newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }
        if (i==intervals.length ||newInterval[1] < intervals[i][0]) {
            list.addLast(newInterval);
        } else {
            intervals[i][0] = Math.min(intervals[i][0], newInterval[0]);
            intervals[i][1] = Math.max(intervals[i][1], newInterval[1]);
        }

        while (i < intervals.length) {
            if (list.isEmpty() || intervals[i][0] > list.getLast()[1]) {
                list.add(intervals[i]);
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], intervals[i][1]);
            }
            i++;
        }

        return list.toArray(new int[0][]);
    }
}
