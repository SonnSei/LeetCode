package p77组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/17 7:40
 * @Author SonnSei
 */
public class Solution1 {
    public static void main(String[] args) {
        List<List<Integer>> lists = combine(3, 3);
        for (List list : lists) {
            System.out.println(list);
        }
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        if (n < 1 || k < 1) {
            ret.add(tmp);
            return ret;
        }

        for (int i = 1; i <=n ; i++) {
            tmp.add(i);
            trackBack(i,n, k-1,tmp, ret);
            tmp.remove(tmp.size() - 1);
        }
        return ret;
    }

    private static void trackBack(int index,int n, int cnt, ArrayList<Integer> list, List<List<Integer>> ret) {
        if (cnt == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }
        if(cnt>n-index+1)return;

        for (int i = index+1; i <=n ; i++) {
            list.add(i);
            trackBack(i,n,cnt-1,list,ret);
            list.remove(list.size() - 1);
        }
    }
}
