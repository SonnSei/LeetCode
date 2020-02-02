package g0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname Solution46
 * @Description 全排列
 * @Date 2019/12/17 9:29
 * @Created by SunCheng
 */
public class Solution46 {
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> ret = new ArrayList<>();
//        permute(ret, nums, 0);
//        return ret;
//    }
//
//    private void permute(List<List<Integer>> ret, int[] nums, int index) {
//        if (index == nums.length) {
//            ArrayList<Integer> list = new ArrayList<>();
//            for (int val : nums) {
//                list.add(val);
//            }
//            ret.add(list);
//        }
//        for (int i = index; i < nums.length; i++) {
//            swap(nums, index, i);
//            permute(ret, nums, index + 1);
//            swap(nums, index, i);
//        }
//    }
//
//    public static void swap(int[] nums,int a,int b){
//        int temp = nums[a];
//        nums[a] = nums[b];
//        nums[b] = temp;
//    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> numList = new ArrayList<>();
        for (int val : nums) {
            numList.add(val);
        }
        permute(ret, numList, 0,nums.length);
        return ret;
    }

    private void permute(List<List<Integer>> ret, ArrayList<Integer> numList, int index,int len) {
        if (index == len) {
            ret.add(new ArrayList<>(numList));
        }
        for (int i = index; i <len ; i++) {
            Collections.swap(numList,index,i);
            permute(ret, numList, index + 1, len);
            Collections.swap(numList,index,i);
        }
    }
}
