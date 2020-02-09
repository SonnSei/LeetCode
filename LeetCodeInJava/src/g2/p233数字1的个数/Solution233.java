package g2.p233数字1的个数;

/**
 * @Classname Solution233
 * @Description 数字 1 的个数
 * @Date 2019/12/22 9:10
 * @Author SonnSei
 */
public class Solution233 {
    public int countDigitOne(int n) {
        if(n<1)return 0;
        int ret = 0;
        // 因为i每次要乘以10，所以i可能超过int的范围，所以用long
        // 事实上，如果用int，确实会有越界的测试用例
        long i = 1;
        long cur, left, right = 0;
        while ((n / i) != 0) {
            // 当前位
            cur = n / i % 10;
            // 高位数字
            left = n / (i * 10);
            // 低位数字
            right = n % i;

            if (cur == 0) {
                //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
                ret += left * i;
            } else if (cur == 1) {
                //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
                ret += left * i + right + 1;
            } else {
                //如果大于1,出现1的次数由高位决定,//（高位数字+1）* 当前位数
                ret += (left + 1) * i;
            }
            i *= 10;
        }
        return ret;
    }
}
