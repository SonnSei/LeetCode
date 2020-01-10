package p5最长回文字串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname Solution2
 * @Description TODO
 * @Date 2020/1/10 17:37
 * @Author SonnSei
 */
public class Solution2 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)return "";
        List<Character> list = new ArrayList<>(s.length()*2+1);
        for (int i = 0; i < s.length(); i++) {
            list.add('#');
            list.add(s.charAt(i));
        }
        list.add('#');

        int maxMid=0,maxRight = 0;
        int retMid = 0,maxRadius = 0;

        // 这里不要写成s.length()
        int[] dp = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            dp[i] = maxRight>i?Math.min(dp[maxMid*2-i],maxRight-i):1;
            while((i-dp[i])>=0 &&(i+dp[i])<list.size() && list.get(i+dp[i])==list.get(i-dp[i]))
                dp[i]++;
            if (dp[i] > maxRadius) {
                maxRadius = dp[i];
                retMid = i;
            }
            if ((i + dp[i]) > maxRight) {
                maxRight = i + dp[i];
                maxMid = i;
            }
        }
        StringBuilder ret = new StringBuilder();
        for (int i = retMid-maxRadius+1; i <retMid+maxRadius ; i++) {
            char c = list.get(i);
            if(c!='#') ret.append(c);
        }
        return ret.toString();
    }
}
