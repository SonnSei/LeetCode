package p9回文数;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/10 18:28
 * @Author SonnSei
 */
public class Solution1 {
    public boolean isPalindrome(int x) {
        String s = ""+x;
        for (int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
}
