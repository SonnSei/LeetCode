package g0.p44通配符匹配;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/2/11 16:07
 * @Author SonnSei
 */
public class Solution2 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // 当s为空时，全为‘*’的模式串才匹配
        for (int i = 1; i <= p.length(); i++) {
            if(p.charAt(i-1)!='*')break;
            dp[0][i]=true;
        }

        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 1; j <=p.length() ; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);
                if(sChar==pChar||pChar=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(pChar=='*'){
                    dp[i][j]=dp[i-1][j-1]||dp[i][j-1]||dp[i-1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
