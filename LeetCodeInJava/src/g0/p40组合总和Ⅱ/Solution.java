package g0.p40组合总和Ⅱ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/24 21:18
 * @Author SonnSei
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ret;
        Arrays.sort(candidates);
        recurse(candidates, new boolean[candidates.length],0, ret, new ArrayList<>(), target);
        return ret;
    }


    private void recurse(int[] candidates, boolean[] used, int start, List<List<Integer>> ret, ArrayList<Integer> tmp, int target) {
        if (target == 0) {
            ret.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if((i>0&&!used[i-1]&&candidates[i]==candidates[i-1] )||used[i])continue;
            tmp.add(candidates[i]);
            used[i] = true;
            recurse(candidates, used,i+1, ret, tmp, target - candidates[i]);
            used[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
