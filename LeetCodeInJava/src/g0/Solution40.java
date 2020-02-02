package g0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname Solution40
 * @Description TODO
 * @Date 2020/1/5 19:17
 * @Author SonnSei
 */
public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if(candidates==null || candidates.length==0)return ret;
        boolean[] used = new boolean[candidates.length];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(ret, list, candidates, used,0,target);
        return ret;
    }

    private void backTracking(List<List<Integer>> ret, List<Integer> list, int[] candidates, boolean[] used, int start, int target) {
        if (target==0) {
            ret.add(new ArrayList<>(list));
            return;
        }
        if(start>=candidates.length||candidates[start]>target)return;
        // 如果从0开始，输出的是全排列，123！=321这样子
        for (int i = start; i < candidates.length; i++) {
            if(used[i])continue;
            if(i>0 && candidates[i]==candidates[i-1] && !used[i-1])continue;
            list.add(candidates[i]);
            used[i] = true;
            backTracking(ret,list,candidates,used,i,target-candidates[i]);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
