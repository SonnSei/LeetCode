package g0.p44通配符匹配;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/10 11:26
 * @Author SonnSei
 */
public class Solution {
    public static void main(String[] args) {

        String a = "aaabababaaabaababbbaaaabbbbbbabbbbabbbabbaabbababab";
        String b = "*ab***ba**b*b*aaab*b";
        System.out.println(isMatch(a, b));
    }
    public static boolean isMatch(String s, String p) {
            if (s == null || p == null) return false;
            if (p.length() == 0) return s.length() == 0;
            if(s.length()==0)return check(p);
            if (p.charAt(0) == '?') return isMatch(s.substring(1), p.substring(1));
            if (p.charAt(0) == '*') return isMatch(s.substring(1), p) ||
                    isMatch(s.substring(1), p.substring(1))||
                    isMatch(s,p.substring(1));
            if(s.length()>0&&s.charAt(0)==p.charAt(0))
                return isMatch(s.substring(1), p.substring(1));
            return false;
    }

    private static boolean check(String p) {
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i)!='*')return false;
        }
        return true;
    }
}
