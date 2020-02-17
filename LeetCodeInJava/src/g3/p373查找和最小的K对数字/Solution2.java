package g3.p373查找和最小的K对数字;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/2/14 9:37
 * @Author SonnSei
 */
public class Solution2 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums1==null||nums1.length==0||nums2==null||nums2.length==0)return list;
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i <nums1.length ; i++) {
            for (int j = 0; j < nums2.length; j++) {
                tmp.clear();
                tmp.add(nums1[i]);
                tmp.add(nums2[j]);
                list.add(new ArrayList<>(tmp));
            }
        }
        Collections.sort(list, Comparator.comparingInt(a->a.get(0)+a.get(1)));
        List<List<Integer>> ret = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            if(i>=list.size())break;
            ret.add(list.get(i));
        }

        return ret;

    }
}
