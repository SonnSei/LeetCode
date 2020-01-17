package p76最小覆盖字串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/16 10:06
 * @Author SonnSei
 */
public class Solution2 {

    static Map<Character,Integer> tMap;
    public static String minWindow(String s, String t) {
        if(s==null || t==null ||s.length()<t.length())return "";
        tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int min = s.length();
        boolean found = false;
        int start = 0;
        for (int right = 0; right < s.length(); right++) {
            int leftBorder = findLeftBorder(right, s);
            if (leftBorder != -1) {
                found = true;
                if (right - leftBorder + 1 < min) {
                    min = right-leftBorder+1;
                    start = leftBorder;
                }
            }
        }
        if(!found)return "";
        return s.substring(start, min + start);
    }

    private static int findLeftBorder(int index, String s) {
        Map<Character, Integer> map = new HashMap<>(tMap);
        while (index >= 0 && !map.isEmpty()) {
            Character c = s.charAt(index);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c)==0) map.remove(c);
            }
            index--;
        }
        if(!map.isEmpty())return -1;
        // 边界问题
        return index+1;
    }
}
