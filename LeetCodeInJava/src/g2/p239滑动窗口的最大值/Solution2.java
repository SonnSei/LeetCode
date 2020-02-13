package g2.p239滑动窗口的最大值;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/2/13 15:35
 * @Author SonnSei
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = {7,2,4};
        int[] ints = solution2.maxSlidingWindow(nums, 2);
        System.out.println(Arrays.toString(ints));
    }

    ArrayDeque<Integer> deque = new ArrayDeque<>();
    int[] nums;
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0) return new int[0];
        if(k==1)return nums;
        this.nums = nums;
        int[] ret = new int[nums.length - k+1];
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            handleQueue(i, k);
            deque.addLast(i);
            if(nums[i]>nums[maxIndex])maxIndex=i;
        }
        ret[0] = nums[maxIndex];
        for (int i = k; i <nums.length ; i++) {
            handleQueue(i,k);
            deque.addLast(i);
            ret[i-k+1]=nums[deque.getFirst()];
        }
        return ret;
    }

    private void handleQueue(int i, int k) {
        if(!deque.isEmpty() && deque.getFirst()==i-k){
            deque.removeFirst();
        }
        while(!deque.isEmpty() && nums[i]>nums[deque.getLast()])
            deque.removeLast();
    }
}
