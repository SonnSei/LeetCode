package g0;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution13
 * @Description 罗马数字转整数
 * @Date 2019/12/14 15:45
 * @Created by SunCheng
 */
public class Solution13 {

    public static void main(String[] args) {
        String s = "IVII";
        System.out.println(new Solution13().romanToInt2(s));

    }
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

    /**
     * 如果前一个数字比后一个数字小的话，代表发生的特殊情况
     * switch比hashmap还要快
     * @param s
     * @return
     */
    public int romanToInt2(String s) {
        int ret = 0;
        int preValue = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int curVlue = getValue(c);
            ret +=curVlue;
            if (preValue < curVlue) {
                ret-=preValue<<1;
            }
            preValue = curVlue;
        }
        return ret;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
