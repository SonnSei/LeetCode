package g2.p239滑动窗口的最大值;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/13 13:15
 * @Author SonnSei
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (nums == null || size <= 0 || size > nums.length) {
            return new int[]{};
        }

        ArrayList<Integer> temp = null;
        int length = nums.length;

        for (int i = 0; i < length - size + 1; i++) {
            temp = new ArrayList<Integer>();
            for (int j = i; j < size + i; j++) {
                temp.add(nums[j]);
            }
            Collections.sort(temp);
            ret.add(temp.get(temp.size() - 1));
        }
        int[] res = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            res[i] = ret.get(i);
        }
        return res;
    }
}
