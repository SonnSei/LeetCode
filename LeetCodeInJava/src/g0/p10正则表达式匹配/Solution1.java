package g0.p10正则表达式匹配;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/11 5:09
 * @Author SonnSei
 */
public class Solution1 {
    public boolean isMatch(String s, String p) {
        // 下面这句就没有必要了
//        if(s.length() == 0 && p.length() == 0)return true;
        if (p.length() == 0) return s.length() == 0;
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        // ‘*’对前一个字符的影响有：0个，1个，多个，分析一下可知0个与多个的可以拼凑出1个的情况，所以只需要判断这两种情况
        // 三种情况都写的话，会超时
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
