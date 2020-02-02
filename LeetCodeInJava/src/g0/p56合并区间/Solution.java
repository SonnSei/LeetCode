package g0.p56合并区间;

import java.util.*;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/27 10:13
 * @Author SonnSei
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> list = new LinkedList<>();
        if (intervals == null || intervals.length == 0) return list.toArray(new int[0][0]);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length; i++) {
            if (list.isEmpty() || intervals[i][0] > list.getLast()[1]) {
                list.add(intervals[i]);
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], intervals[i][1]);
            }
        }
        return list.toArray(new int[0][0]);
    }
}
