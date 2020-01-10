package p6Z字形变换;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/10 17:58
 * @Author SonnSei
 */
public class Solution1 {
    public String convert(String s, int numRows) {
        if(s==null ||s.length() == 0||numRows<2)return s;
        List<List<Character>> lists = new ArrayList<>();
        // 不要忘记初始化
        for (int i = 0; i < numRows; i++) {
            lists.add(new ArrayList<>());
        }
        boolean turn = false;
        int rowIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            lists.get(rowIndex).add(s.charAt(i));
            if (rowIndex == 0 || rowIndex == numRows - 1) turn = !turn;
            rowIndex = turn ? rowIndex + 1 : rowIndex - 1;
        }
        StringBuilder ret = new StringBuilder();
        for (List<Character> list : lists)
            for (Character c : list)
                ret.append(c);
        return ret.toString();
    }
}
