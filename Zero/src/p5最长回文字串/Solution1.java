package p5最长回文字串;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/10 17:36
 * @Author SonnSei
 */
public class Solution1 {
    /**
     * 中心扩展法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)return "";
        int max = 0;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s,i,i);
            int len2 = expand(s,i,i+1);
            int len= Math.max(len1,len2);
            if(len>max){
                max = len;
                begin = i-(len-1)/2;
            }
        }
        return s.substring(begin,begin+max);
    }

    private int expand(String s, int l, int r){
        while(l>=0 && r< s.length() && s.charAt(l)==s.charAt(r)){
            l--;r++;
        }
        return r-l-1;
    }
}
