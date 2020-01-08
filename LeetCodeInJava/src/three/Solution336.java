package three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname Solution336
 * @Description TODO
 * @Date 2020/1/8 9:55
 * @Author SonnSei
 */
public class Solution336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> ret = new ArrayList<>();
        if(words==null || words.length==0)return ret;
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            String s = reverse(words[i]);
            if (!map.containsKey(s)) continue;

            if (map.get(s) != i) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(map.get(s));
                ret.add(temp);
            }
        }
        return ret;
    }

    private String reverse(String word) {
        StringBuilder ret = new StringBuilder(word);
        return ret.reverse().toString();
    }
}
