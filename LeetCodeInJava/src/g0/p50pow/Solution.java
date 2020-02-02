package g0.p50pow;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/13 22:14
 * @Author SonnSei
 */
public class Solution {
    public double myPow(double x, int n) {
        if(n == 0)return 1.0;
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if(n ==0)return 1.0;
        double half = fastPow(x, n / 2);
        double ret = half*half;
        if((n&1)!=0)ret*=x;
        return ret;
    }
}
