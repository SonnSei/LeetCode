package p60第K个排列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/15 14:41
 * @Author SonnSei
 */
public class Solution1 {
    public static void main(String[] args) {
        System.out.println(getPermutation(3,3));
    }

    public static String getPermutation(int n, int k) {
        int sum = 1;
        int cnt = 1;
        while (sum < k) {
            cnt++;
            sum*=cnt;
        }
        StringBuilder ret= new StringBuilder();
        for (int i = 1; i <=(n-cnt) ; i++) {
            ret.append(i);
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]  = i+1;
        }
        List<String> list = new ArrayList<>();
        trackBack(nums,new boolean[n] ,n-cnt,n-cnt, list, ret);
        Collections.sort(list);

        return list.get(k-1);

    }

    private static void trackBack(int[] nums,boolean[] used,int start, int index, List<String> list, StringBuilder ret) {
        if (index == nums.length) {
            list.add(ret.toString());
            return;
        }
        for (int i = start; i <nums.length ; i++) {
            if(used[i])continue;
            used[i] = true;
            ret.append(nums[i]);
            trackBack(nums, used,start,index + 1, list, ret);
            ret.deleteCharAt(ret.length() - 1);
            used[i] = false;
        }
    }
}
