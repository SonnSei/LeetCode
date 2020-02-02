package g0.p57插入区间;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution3
 * @Description
 * @Date 2020/1/15 9:55
 * @Author SonnSei
 */
public class Solution3 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int index = 0;
        while (index<intervals.length && intervals[index][1] < newInterval[0]) {
            list.add(intervals[index++]);
        }
        list.add(newInterval);
        for (int i = index; i <intervals.length ; i++) {
            int[] cur = intervals[i];
            int[] tmp;
            if (!list.isEmpty() && (tmp = list.get(list.size() - 1))[1] >= cur[0]) {
                tmp[1] = Math.max(tmp[1], cur[1]);
                tmp[0] = Math.min(tmp[0], cur[0]);
            } else {
                list.add(cur);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
