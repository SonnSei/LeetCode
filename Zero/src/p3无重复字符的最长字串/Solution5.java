package p3无重复字符的最长字串;

/**
 * @Classname Solution5
 * @Description TODO
 * @Date 2020/1/10 17:00
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
        int max = 1;
        int left = 0, right = 0;
        while(right<s.length()){
            char c = s.charAt(right);
            int index = s.substring(left, right).indexOf(c);
            // 注意这里是大于等于0
            if(index>=0)left = index+1+left;
            max = Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}
