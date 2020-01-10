package p3无重复字符的最长字串;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution3
 * @Description TODO
 * @Date 2020/1/10 16:58
 * @Author SonnSei
 */
public class Solution3 {
    /**
     * 利用map，时间复杂度O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        if(s==null || s.length() == 0)return 0;
        Map<Character,Integer> map = new HashMap<>();
        int max = 1;
        int left = 0,right = 0;
        while(right<s.length()){
            char c = s.charAt(right);
            left = Math.max(left,map.getOrDefault(c, 0));
            max = Math.max(max,right-left+1);
            map.put(c,right+1);
            right++;
        }
        return max;
    }
}
