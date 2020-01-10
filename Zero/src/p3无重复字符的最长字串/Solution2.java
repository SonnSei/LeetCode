package p3无重复字符的最长字串;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname Solution2
 * @Description TODO
 * @Date 2020/1/10 16:58
 * @Author SonnSei
 */
public class Solution2 {
    /**
     * 双指针，时间复杂度O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0)return 0;
        Set<Character> set = new HashSet<>();
        int ret = 1;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (set.contains(c)) {
                while (s.charAt(left) != c) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            ret = Math.max(right-left+1,ret);
        }
        return ret;
    }
}
