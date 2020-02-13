package g3.p347前K个高频元素;

import java.util.*;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/13 17:46
 * @Author SonnSei
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ret = new ArrayList<>(k);
        if(nums==null || nums.length==0)return ret;
        if(k<1)return ret;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        Arrays.sort(nums);
        int i = 0;
        while(i<nums.length){
            int cur = nums[i];
            int size =1;
            // 不要忘记越界判断
            while(i+1<nums.length && nums[i+1]==cur){
                size++;
                i++;
            }
            i++;
            priorityQueue.add(new int[]{cur, size});
        }
        for (int j = 0; j < k; j++) {
            ret.add(priorityQueue.poll()[0]);
        }
        return ret;
    }
}
