package g0.p3无重复最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution3
 * @Description
 * @Date 2020/2/2 10:47
 * @Author SonnSei
 */
public class Solution3 {
    /**
     * 利用map，时间复杂度O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        if(s == null || s.length() == 0)return 0;
        int ret = 1;
        // left是无重复字符串开始的位置
        int left = 0;
        // map中，key是字符，value是该字符出现的上一个位置
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c)+1);
            }
            ret = Math.max(ret, i - left + 1);
            map.put(c, i);
        }
        return ret;
    }
}
