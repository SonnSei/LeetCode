package p17电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/12 9:31
 * @Author SonnSei
 */
public class Solution1 {
    static String[] numbers = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if(digits == null || digits.length()==0)return ret;
        StringBuilder tmp = new StringBuilder();
        recursion(digits,0,tmp,ret);
        return ret;
    }

    private void recursion(String digits, int index, StringBuilder tmp, List<String> ret) {
        if (index == digits.length()) {
            ret.add(tmp.toString());return;
        }
        String chars = numbers[digits.charAt(index)-'2'];
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            tmp.append(c);
            recursion(digits,index+1,tmp,ret);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
