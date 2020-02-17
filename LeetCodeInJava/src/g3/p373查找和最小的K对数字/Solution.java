package g3.p373查找和最小的K对数字;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/14 9:16
 * @Author SonnSei
 */
public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]+a[1]));
        List<List<Integer>> ret = new ArrayList<>();
        if(nums1==null||nums1.length==0||nums2==null||nums2.length==0)return ret;
        for (int i = 0; i <nums1.length ; i++) {
            for (int j = 0; j < nums2.length; j++) {
                priorityQueue.add(new int[]{nums1[i],nums2[j]});
            }
        }
        List<Integer> tmp = new ArrayList<>(2);
        for (int i = 0; i < k; i++) {
            if(priorityQueue.isEmpty())break;
            int[] cur = priorityQueue.poll();
            tmp.clear();
            tmp.add(cur[0]);
            tmp.add(cur[1]);
            ret.add(new ArrayList<>(tmp));
        }
        return ret;
    }
}
