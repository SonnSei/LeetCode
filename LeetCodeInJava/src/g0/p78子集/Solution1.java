package g0.p78子集;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/17 8:02
 * @Author SonnSei
 */
public class Solution1 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = subsets(nums);
        for (List list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        ret.add(tmp);
        if (nums == null || nums.length < 1)return ret;
        for (int i = 1; i <=nums.length ; i++) {
            backTrack(nums, 0, i, tmp, ret);
        }

        return ret;
    }

    private static void backTrack(int[] nums, int index, int n, List<Integer> tmp, List<List<Integer>> ret) {
        if (tmp.size() == n) {
            ret.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = index; i <nums.length ; i++) {
            tmp.add(nums[i]);
            backTrack(nums,i+1,n,tmp,ret);
            tmp.remove(tmp.size() - 1);
        }
    }
}
