package g0.p32最长有效括号;

/**
 * @Classname Solution
 * @Description 动态规划
 * @Date 2020/2/9 16:02
 * @Author SonnSei
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int ret = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // 注意把三目运算符放在括号里
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // (i - dp[i - 1]) >= 2 与 i-dp[i-1]-1>=2 均可
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                ret = Math.max(ret, dp[i]);
            }
        }
        return ret;
    }
}
