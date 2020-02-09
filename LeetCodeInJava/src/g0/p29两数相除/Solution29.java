package g0.p29两数相除;

/**
 * @Classname Solution29
 * @Description TODO
 * @Date 2019/12/28 14:01
 * @Author SonnSei
 */
public class Solution29 {
    public static void main(String[] args) {
        int a = 1100540749;
        int b = -1090366779;
        System.out.println(divide(a, b));
        System.out.println(true ^ true);
    }


    /**
     * 全部用负数
     * @param dividend
     * @param divisor
     * @return
     */
    private static int divide(int dividend, int divisor) {
        boolean negative = (dividend > 0) ^ (divisor > 0);
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        int ret = 0;
        int add = 1;
        int div = divisor;
        while (dividend <= div) {
            while (div << 1 >= dividend) {
                if (div <= Integer.MIN_VALUE >> 1) break;
                div <<= 1;
                add <<= 1;
                // 加在这里是不行的，因为负溢出之后div << 1 >= dividend也能成立，
                // 如果在这之前对div进行了左移，那就出错了
                //if(div<=Integer.MIN_VALUE>>1)break;
            }
            ret -= add;
            dividend -= div;
            add = 1;
            div = divisor;
        }
        if (!negative && ret == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return negative ? ret : -ret;
    }




    /**
     * 正数区间比较麻烦
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide2(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == Integer.MIN_VALUE) return dividend == Integer.MIN_VALUE ? 1 : 0;
        if (divisor == 1) return dividend;

        boolean negative = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            negative = true;
        }

        int ret = 0;
        int add = 1;


        if (dividend == Integer.MIN_VALUE) {
            ret++;
            dividend -= divisor;
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int div = divisor;
        while (dividend >= div) {
            System.out.println("dividend: " + dividend);
            ret += add;
            dividend -= div;
            if (dividend == 0) break;
            if (dividend < div) {
                add = 1;
                div = divisor;
            } else if (div < (dividend >> 1)) {
                div <<= 1;
                add <<= 1;
            }
        }
        return negative ? -ret : ret;
    }
}
