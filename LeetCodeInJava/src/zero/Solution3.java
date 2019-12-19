package zero;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname Solution3
 * @Description 无重复字符的最长子串
 * @Date 2019/12/9 8:40
 * @Created by Jesse
 */
public class Solution3 {
    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring5("abcabcbb"));
    }

    /**
     * 利用字符串的indexOf
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring5(String s) {
        if(s==null || s.length() == 0)return 0;
        int ret = 0;
        for (int left=0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            int position = s.substring(left, right).indexOf(c);
            // 需要移动左指针的情况
            if (position >= 0) {
                left = left + position + 1;
            } else {
                ret = Math.max(ret, right - left + 1);
            }
        }
        return ret;
    }


    /**
     * 数组代替map
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring4(String s) {
        if(s==null || s.length() == 0)return 0;
        int ret = 0;
        int[] map = new int[128];
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            left = Math.max(left, map[s.charAt(i)]);
            ret = Math.max(ret, i - left+1);
            map[s.charAt(i)] =i+1;
        }
        return ret;
    }

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
