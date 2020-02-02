package g0.p10正则表达式匹配;

/**
 * @Classname Solution2
 * @Description TODO
 * @Date 2020/1/11 5:27
 * @Author SonnSei
 */
public class Solution2 {
    /**
     * 动态规划，从后往前（自底向上）
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = s.length(),n = p.length();
        Boolean[][] dp = new Boolean[m+1][n+1];
        dp[m][n] = true;
        for (int i = m; i >=0; i--) {
            for (int j = n-1; j >=0 ; j--) {
                // 这一句后面的判断没有加括号，导致失败
                //boolean firstMatch = i < s.length() && s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
                boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j+2] || firstMatch && dp[i+1][j];
                }else
                    dp[i][j] = firstMatch && dp[i+1][j+1];
            }
        }
        return dp[0][0];
    }
}
