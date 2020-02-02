package g0;

import java.util.*;

/**
 * @Classname Solution47
 * @Description 全排列Ⅱ
 * @Date 2019/12/17 10:09
 * @Created by SunCheng
 */
public class Solution47 {
    public static void main(String[] args) {
        int[] nums = {1,1, 2};
        System.out.println(new Solution47().permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> numsList = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permuteUnique(ret, nums,numsList,used, 0, nums.length);
        return ret;
    }

    private void permuteUnique(List<List<Integer>> ret, int[] nums, ArrayList<Integer> numsList, boolean[] used, int index, int length) {
        if (index == length) {
            ret.add(new ArrayList<>(numsList));
            return;
        }
        // 这个地方和全排列Ⅰ不同，这里是从0开始
        // 因为我们要记录used，所以不用swap跳来跳去，所以用的是一个list做记录
        // 全排列Ⅰ中，只要到了index，则index之前的事情是不需要当前递归层次考虑的
        // 在这里，显然如果从index开始，那只有0号元素作为开始的时候才有可能index==length
        for (int i = 0; i < length; i++) {
            if(used[i])continue;;
            if(i>0 && !used[i-1] && nums[i-1]==nums[i])continue;
            used[i] = true;
            numsList.add(nums[i]);
            permuteUnique(ret,nums,numsList,used,index+1,length);
            numsList.remove(numsList.size() - 1);
            used[i] = false;
        }
    }
}
