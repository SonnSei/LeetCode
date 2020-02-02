package g0.p3无重复最长子串;

/**
 * @Classname Solution5
 * @Description
 * @Date 2020/2/2 10:48
 * @Author SonnSei
 */
public class Solution5 {
    /**
     * 利用字符串的indexOf
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring5(String s) {
        if(s==null || s.length() == 0)return 0;
        int ret = 0;
        for (int left=0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            int position = s.substring(left, right).indexOf(c);
            // 需要移动左指针的情况
            if (position >= 0) {
                left = left + position + 1;
            } else {
                ret = Math.max(ret, right - left + 1);
            }
        }
        return ret;
    }
}
