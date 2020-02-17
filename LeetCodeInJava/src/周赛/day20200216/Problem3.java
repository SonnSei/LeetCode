package 周赛.day20200216;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname Problem3
 * @Description 最多可以参加的会议数目
 * @Date 2020/2/16 10:18
 * @Author SonnSei
 */
public class Problem3 {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
        boolean[] vis = new boolean[100001];
        int res = 0;
        for (int[] it : events) {
            for (int i = it[0]; i <= it[1]; i++) {
                if (vis[i] == false) {
                    vis[i] = true;
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
