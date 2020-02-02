package g0.p6之字型变换;

import java.util.ArrayList;

/**
 * @Classname Solution6
 * @Description TODO
 * @Date 2019/12/9 9:48
 * @Created by SonnSei
 */
public class Solution6 {
    //关键是搞清楚题意，然后有一个转弯的标识reverse
    public static String convert(String s, int numRows) {
        if (s == null || s.length() < 2 || numRows < 2) return s;
        ArrayList<Character>[] lists = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            lists[i] = new ArrayList<>();
        }
        boolean reverse = false;
        int rowIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lists[rowIndex].add(c);
            rowIndex = reverse ? rowIndex - 1 : rowIndex + 1;
            if (rowIndex == 0 || rowIndex == numRows - 1)
                reverse = !reverse;
        }
        StringBuilder ret = new StringBuilder();
        for (ArrayList<Character> l :
                lists) {
            for (char c :
                    l) {
                ret.append(c);
            }
        }
        return ret.toString();
    }
}
