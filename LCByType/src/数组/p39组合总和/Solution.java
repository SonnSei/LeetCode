package 数组.p39组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/24 20:17
 * @Author SonnSei
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ret;
        Arrays.sort(candidates);
        recurse(candidates, target, 0, ret, new ArrayList<>());
        return ret;
    }

    private void recurse(int[] candidates, int target, int start, List<List<Integer>> ret, List<Integer> tmp) {
        if (target == 0) {
            ret.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            tmp.add(candidates[i]);
            recurse(candidates, target - candidates[i], i, ret, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
