package p13罗马数字转整数;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/11 6:50
 * @Author SonnSei
 */
public class Solution1 {
    /* 优先匹配两个字符的 */
    public int romanToInt(String s) {
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            map.put(strs[i], value[i]);
        }
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char nextChar = '*';
            if (i < s.length() - 1) {
                nextChar = s.charAt(i + 1);
            }
            if (map.containsKey(""+c + nextChar )) {
                ret += map.get(""+c + nextChar );
                i++;
            } else {
                ret += map.get(c + "");
            }
        }
        return ret;
    }
}
