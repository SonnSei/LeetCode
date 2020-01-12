package p58最后一个单词的长度;

/**
 * @Classname Solution2
 * @Description TODO
 * @Date 2020/1/13 0:07
 * @Author SonnSei
 */
public class Solution2 {
    public int lengthOfLastWord(String s) {
        if(s==null || (s = s.trim()).length() == 0)return 0;
        String[] strs = s.split(" ");
        return strs[strs.length-1].length();
    }
}
