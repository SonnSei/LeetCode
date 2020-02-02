package g0.p3无重复最长子串;

/**
 * @Classname Solution4
 * @Description
 * @Date 2020/2/2 10:48
 * @Author SonnSei
 */
public class Solution4 {
    /**
     * 数组代替map
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring4(String s) {
        if(s==null || s.length() == 0)return 0;
        int ret = 0;
        int[] map = new int[128];
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            left = Math.max(left, map[s.charAt(i)]);
            ret = Math.max(ret, i - left+1);
            map[s.charAt(i)] =i+1;
        }
        return ret;
    }
}
