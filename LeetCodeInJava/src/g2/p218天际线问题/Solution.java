package g2.p218天际线问题;

import java.util.*;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/13 11:52
 * @Author SonnSei
 */
public class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ret = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        List<int[]> points = new ArrayList<>(2 * buildings.length);
        for (int[] build : buildings) {
            points.add(new int[]{build[0], build[2]});
            points.add(new int[]{build[1], -build[2]});
        }
        List<Integer> tmp = new ArrayList<>(2);
        // 要高的在上，下面这个是错的
//        Collections.sort(points,(o1,o2)->o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);

        Collections.sort(points,(o1,o2)->o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0]);

        int cur=0,pre=0;
        for (int[] point : points) {
            if (point[1] > 0) {
                maxHeap.add(point[1]);
                cur = maxHeap.peek();
            } else {
                maxHeap.remove(-point[1]);
                cur = maxHeap.size()==0?0:maxHeap.peek();
            }
            if (cur != pre) {
                tmp.clear();
                tmp.add(point[0]);
                tmp.add(cur);
                ret.add(new ArrayList<>(tmp));
                pre = cur;
            }
        }
        return ret;
    }
}
