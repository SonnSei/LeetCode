package p14最长公共前缀;

/**
 * @Classname Solution3
 * @Description TODO
 * @Date 2020/1/12 8:17
 * @Author SonnSei
 */
public class Solution3 {
    /**
     * 感觉这个分治也挺蠢
     * 时间复杂度：O（s）
     * 空间复杂度O(m*log(n))
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int left, int right) {
        if(left==right) return strs[left];
        int mid = (left+right)>>>1;
        String sl = longestCommonPrefix(strs, left, mid);
        String sr = longestCommonPrefix(strs, mid + 1, right);
        return commonPrefix(sl, sr);
    }

    private String commonPrefix(String s1, String s2) {
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if(s1.charAt(i)!=s2.charAt(i))return s1.substring(0,i);
        }
        return s1.length()>s2.length()?s2:s1;
    }
}
