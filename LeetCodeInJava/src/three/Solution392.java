package three;

import java.util.Arrays;

/**
 * @Classname Solution392
 * @Description 判断子序列
 * @Date 2019/12/20 10:40
 * @Author SunCheng
 */
public class Solution392 {
    public static void main(String[] args) {
        boolean ret = isSubsequence2("axc", "ahbgdc");
        System.out.println(ret);
    }

    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null)return false;
        int lenS = s.length();
        int lenT = t.length();
        if(lenS>lenT)return false;
        int indexT = 0;
        for (int i = 0; i < lenS; i++) {
            char c = s.charAt(i);
            while (indexT<lenT && t.charAt(indexT)!=c) {
                indexT++;
            }
            if (indexT == lenT) {
                return false;
            }
            // 不要忘了这个
            indexT++;
        }
        return true;
    }


    // todo
    public static boolean isSubsequence2(String s, String t) {
        if(s == null || t == null)return false;
        int lenS = s.length();
        int lenT = t.length();
        if(lenS>lenT)return false;
        boolean[][] dp = new boolean[lenS +1][lenT+ 1];
        for (int i = 0; i <= lenT; i++) {
            dp[0][i] = true;

        }
        for (int i = 1; i <= lenT; i++) {
            if (t.charAt(i-1) == s.charAt(0)) {
                dp[1][i] = true;
            }else
                dp[1][i] = dp[1][i - 1];
        }


        for (int i = 0; i < lenS; i++) {
            for (int j = 0; j < lenT; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j+1] = dp[i + 1][j] || dp[i][j + 1];
                }
            }
        }
        for (boolean[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[lenS][lenT];
    }
}
