package g0.p10正则表达式匹配;

/**
 * @Classname Solution3
 * @Description TODO
 * @Date 2020/1/11 6:06
 * @Author SonnSei
 */
public class Solution3 {
    /**
     * 动态规划 从前往后（自顶向下）
     * 完全是递归思路+memeo
     * @param text
     * @param pattern
     * @return
     */
    public boolean isMatch(String text, String pattern) {
        Boolean[][] memo = new Boolean[text.length() + 1][pattern.length() + 1];
        return dp(memo,0, 0, text, pattern);
    }

    private boolean dp(Boolean[][] memo, int i, int j, String text, String pattern) {
        if(memo[i][j]!=null)return memo[i][j];

        boolean ret = false;
        if (j == pattern.length())return i == text.length();
        boolean firstMatch = i < text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
        if (j < pattern.length() - 1 && pattern.charAt(j + 1) == '*') {
            ret = dp(memo, i, j + 2, text, pattern) || (firstMatch && dp(memo, i + 1, j, text, pattern));
        } else {
            ret = firstMatch && dp(memo, i + 1, j + 1, text, pattern);
        }
        memo[i][j] = ret;
        return ret;
    }
}
