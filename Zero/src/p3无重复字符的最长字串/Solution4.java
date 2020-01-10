package p3无重复字符的最长字串;

/**
 * @Classname Solution4
 * @Description TODO
 * @Date 2020/1/10 16:59
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
        int[] arr = new int[128];
        int max = 1;
        int left =0,right = 0;
        while(right<s.length()){
            char c = s.charAt(right);
            left = Math.max(left,arr[c]);
            max = Math.max(right-left+1,max);
            arr[c] = right+1;
            right++;
        }
        return max;
    }
}
