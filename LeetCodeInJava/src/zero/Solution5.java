package zero;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution5
 * @Description TODO
 * @Date 2019/12/9 9:45
 * @Created by Cheng
 */
public class Solution5 {
    /**
     * 中心扩展法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    /**
     * 马拉车
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        //处理字符串
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add('#');
            list.add(s.charAt(i));
        }
        list.add('#');
        int[] dp = new int[list.size()];
        int resLen = 0;
        int resCenter = 0;
        int maxR = 0;
        int maxM = 0;

        for (int i = 1; i <list.size() ; i++) {
            dp[i] = maxR>i?Math.min(dp[maxM*2-i],maxR-i):1;
            while((i-dp[i])>=0 && (i+dp[i])<list.size() && list.get(i+dp[i]) == list.get(i-dp[i]))
                dp[i]++;
            if (i + dp[i] > maxR) {
                maxR = i+dp[i];
                maxM = i;
            }
            if (resLen < dp[i]) {
                resLen = dp[i];
                resCenter = i;
            }
        }
        StringBuilder ret = new StringBuilder();
        for (int i = resCenter-resLen+1; i <=resCenter+resLen-1 ; i++) {
            if(list.get(i)!='#')
                ret.append(list.get(i));
        }
        return ret.toString();
    }
}
