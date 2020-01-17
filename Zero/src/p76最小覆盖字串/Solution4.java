package p76最小覆盖字串;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution4
 * @Description
 * @Date 2020/1/16 18:23
 * @Author SonnSei
 */
public class Solution4 {
    public static String minWindow(String s, String t) {
        if(s==null||t== null || s.length()<t.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c:s.toCharArray()) map.put(c, 0);
        for (char c : t.toCharArray()) {
            if(!map.containsKey(c)) return "";
            map.put(c, map.get(c) + 1);
        }
        // map中代表每个字符需要匹配的次数
        int min = s.length();
        int start = -1;
        int left = 0,right = 0;
        String result = "";
        //记录需要被匹配的次数
        int count = t.length();

        while (right < s.length()) {
            char c = s.charAt(right);
            //将字符进行匹配
            if (map.get(c) > 0) {
                count--;
            }
            map.put(c, map.get(c) - 1);
            right++;
            while (count == 0) {
                //替换最小结果
                if (right - left <= min) {
                    min = right-left;
                    start = left;
                }
                //移动左指针
                char c1 = s.charAt(left);
                // 不需要匹配的字符，在right扫过的时候已经-1了，不会是0
                if (map.get(c1) == 0) {
                    count++;
                }
                map.put(c1, map.get(c1) + 1);
                left++;
            }
        }
        return start==-1?"":s.substring(start,start+min);
    }
}
