package p9回文数;

/**
 * @Classname Solution2
 * @Description TODO
 * @Date 2020/1/10 18:30
 * @Author SonnSei
 */
public class Solution2 {
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        int reverseInt = 0;
        int tmp = x;
        while (tmp != 0) {
            reverseInt*=10;
            reverseInt+=tmp%10;
            tmp/=10;
        }
        return reverseInt==x;
    }
}
