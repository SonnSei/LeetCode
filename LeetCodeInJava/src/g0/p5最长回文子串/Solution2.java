package g0.p5最长回文子串;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/2/2 10:50
 * @Author SonnSei
 */
public class Solution2 {
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
            // 注意下面这一句
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
