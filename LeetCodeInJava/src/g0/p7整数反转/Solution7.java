package g0.p7整数反转;

/**
 * @Classname Solution7
 * @Description TODO
 * @Date 2019/12/9 9:50
 * @Created by SonnSei
 */
public class Solution7 {
    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && x > 7)) return 0;
            if (ret < -Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && x < -8)) return 0;
            ret *= 10;
            ret += x % 10;
            x /= 10;
        }
        return ret;
    }
}
