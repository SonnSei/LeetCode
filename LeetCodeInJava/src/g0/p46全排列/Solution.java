package g0.p46全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/12 11:48
 * @Author SonnSei
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums==null||nums.length==0)return ret;
        boolean[] used = new boolean[nums.length];
        List<Integer> tmp = new ArrayList<>();
        backTrace(nums,0,used,tmp,ret);
        return ret;
    }

    void backTrace(int[] nums,int index,boolean[] used,List tmp,List ret){
        if(index==nums.length){
            ret.add(new ArrayList<>(tmp));
            return;
        }
        for(int i =0;i<nums.length;i++){
            if(used[i])continue;
            used[i]=true;
            tmp.add(nums[i]);
            backTrace(nums,index+1,used,tmp,ret);
            tmp.remove(tmp.size()-1);
            used[i]=false;
        }
    }
}
