package g0.p3无重复最长子串;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/2/2 10:46
 * @Author SonnSei
 */
public class Solution1 {
    /**
     * 暴力解法，时间复杂度O(n^3)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)return 0;
        int ret = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <s.length() ; j++) {
                if (check(s,i,j)) {
                    ret = Math.max(ret, j - i + 1);
                }
            }
        }
        return ret;
    }

    /**
     * 检查字符串s中start--end之间是否有重复字符
     * @param s
     * @param start
     * @param end
     * @return
     */
    private boolean check(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i <=end ; i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }
}
