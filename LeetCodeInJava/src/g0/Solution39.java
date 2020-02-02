package g0;

import java.util.*;

/**
 * @Classname Solution39
 * @Description TODO
 * @Date 2020/1/5 17:56
 * @Author SonnSei
 */
public class Solution39 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = new Solution39().combinationSum(candidates, target);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        backTrack(ret, 0, candidates, target, list);
        return ret;
    }

    private void backTrack(List<List<Integer>> ret, int start, int[] candidates, int target, List<Integer> list) {
        if (target == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <candidates.length ; i++) {
            if(candidates[i]>target)break;
            list.add(candidates[i]);
            backTrack(ret, i,candidates, target - candidates[i], list);
            list.remove(list.size() - 1);
        }
    }


}
