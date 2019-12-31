package zero;

/**
 * @Classname Solution29
 * @Description TODO
 * @Date 2019/12/28 14:01
 * @Author SonnSei
 */
public class Solution29 {
    public static void main(String[] args) {
        int a = -2147483648;
        int b = 2;
        System.out.println(divide(a, b));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        boolean negative = false;
        if (dividend <= 0 && divisor < 0) {
            dividend = -dividend;
            divisor = -divisor;
        } else if (dividend < 0 || divisor < 0) {
            negative = true;
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);
        }
        int ret = 0;
        int add = 1;
        int div = divisor;
        while (dividend >= div) {
            ret += add;
            dividend -= div;
            if (div < Integer.MAX_VALUE >> 1) {
                div <<= 1;
                add <<= 1;
            }

            if (dividend < div) {
                add = 1;
                div = divisor;
            }
        }
        return negative ? 0 - ret : ret;
    }
}
