package p56合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/15 9:23
 * @Author SonnSei
 */
public class Solution2 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> list = new ArrayList<>(intervals.length);
        for (int i = 0; i <intervals.length ; i++) {
            int[] cur = intervals[i];
            int[] tmp;
            if (!list.isEmpty() && (tmp = list.get(list.size() - 1))[1] >= cur[0]) {
                tmp[1] = Math.max(tmp[1], cur[1]);
            } else {
                list.add(cur);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
