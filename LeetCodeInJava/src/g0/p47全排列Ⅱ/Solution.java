package g0.p47全排列Ⅱ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/12 11:49
 * @Author SonnSei
 */
public class Solution {
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
