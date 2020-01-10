package p7整数反转;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/10 18:05
 * @Author SonnSei
 */
public class Solution1 {
    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            if(ret<Integer.MIN_VALUE/10 || (ret == Integer.MIN_VALUE/10 && x<-8))return 0;
            if(ret>Integer.MAX_VALUE/10 || (ret == Integer.MAX_VALUE/10 && x>7))return 0;
            ret*=10;
            ret+=x%10;
            x /=10;
        }
        return ret;
    }
}
