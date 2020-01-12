package p58最后一个单词的长度;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/13 0:04
 * @Author SonnSei
 */
public class Solution1 {
    public int lengthOfLastWord(String s) {
        if(s==null || (s = s.trim()).length() == 0)return 0;
        int ret = 0;
        int right =s.length()-1;
        while (right >= 0 && s.charAt(right) != ' ') {
            right--;ret++;
        }
        return ret;
    }
}
