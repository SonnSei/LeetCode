package g0.p9回文数;

/**
 * @Classname Solution9
 * @Description TODO
 * @Date 2019/12/9 9:56
 * @Created by Jesse
 */
public class Solution9 {

    public boolean isPalindrome(int x) {
        String s = x + "";
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if(x<0)return false;
        int origin = x;
        int compare = 0;
        while (origin != 0) {
            compare*=10;
            compare+=origin%10;
            origin/=10;
        }
        return compare==x;
    }
}
