package p76最小覆盖字串;

import java.util.*;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/16 8:16
 * @Author SonnSei
 */
public class Solution1 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        s = "aa";
        t = "aa";
        System.out.println(minWindow(s,t));
    }

    static List<Character> tInfo;
    public static String minWindow(String s, String t) {
        if(s==null || t==null ||s.length()<t.length())return "";
        tInfo = new ArrayList<>();
        for (int i = 0; i < t.length(); i++) {
            tInfo.add(t.charAt(i));
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
        List<Character> list = new ArrayList<>(tInfo);
        while (index >= 0 && !list.isEmpty()) {
            Character c = s.charAt(index);
            if(list.contains(c)) list.remove(c);
            index--;
        }
        if(!list.isEmpty())return -1;
        // 边界问题
        return index+1;
    }


}
