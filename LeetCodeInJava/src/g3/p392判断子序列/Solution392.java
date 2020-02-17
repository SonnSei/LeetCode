package g3.p392判断子序列;

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
        System.out.println("**********************");
        boolean ret2 = isSubsequence3("axc", "ahbgdc");
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
        int lenS = s.length(),lenT = t.length();
        if(lenS==0)return true;
        if(lenT==0||lenS>lenT)return false;

        // 初始化dp
        boolean[][] dp = new boolean[2][lenT+ 1];
        for (int i = 0; i <= lenT; i++) {
            dp[0][i] = true;
        }
        System.out.println(Arrays.toString(dp[0]));
        for (int i = 1; i <=lenS; i++) {
            for (int j = 0; j <=lenT; j++) {
                // 这个地方，f（i,j）是依赖f（i-1，j）的，但是只有dp[0][0]是true，其余的dp[i][0]都是false
                // 所以当旋转数组转换的时候可能会产生影响
                if (j == 0) {
                    dp[i % 2][0] = i == 0;
                    continue;
                }
                if (s.charAt(i-1)==t.charAt(j-1)) {
                    dp[i%2][j] = dp[(i - 1)%2][j - 1];
                } else {
                    dp[i%2][j] = dp[i%2][j - 1];
                }
            }
            //System.out.println(Arrays.toString(dp[i%2]));
        }

//        for (boolean[] row : dp) {
//            System.out.println(Arrays.toString(row));
//        }
        return dp[lenS&1][lenT];
    }

    public static boolean isSubsequence3(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen > tLen) return false;
        if (sLen == 0) return true;
        boolean[][] dp = new boolean[sLen + 1][tLen + 1];
        //初始化
        for (int j = 0; j < tLen; j++) {
            dp[0][j] = true;
        }
        //dp
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        for (boolean[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[sLen][tLen];
    }
}
