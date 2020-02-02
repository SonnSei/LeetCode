package g0.p49字母异位词分组;

import java.util.*;

/**
 * @Classname Solution2
 * @Description TODO
 * @Date 2020/1/12 23:09
 * @Author SonnSei
 */
public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        List<List<String>> ret = new ArrayList<>();
        Map<String, List> map = new HashMap<>();
        for (String str : strs) {
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                ArrayList<String> list =new ArrayList();
                list.add(str);
                map.put(key,list );
                ret.add(list);
            }
        }
        return ret;
    }
}
