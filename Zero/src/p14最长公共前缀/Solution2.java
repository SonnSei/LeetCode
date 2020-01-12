package p14最长公共前缀;

/**
 * @Classname Solution2
 * @Description TODO
 * @Date 2020/1/12 8:08
 * @Author SonnSei
 */
public class Solution2 {
    /**
     * 愚蠢的暴力
     * 时间复杂度：O(s)，s为所有字符总数
     * 空间复杂度：O(1)
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i))
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
