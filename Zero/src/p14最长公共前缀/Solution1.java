package p14最长公共前缀;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/11 7:00
 * @Author SonnSei
 */
public class Solution1 {
    /**
     * 神仙算法
     * 时间复杂度：O(s)，s为所有字符总数
     * 空间复杂度：O(1)
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
