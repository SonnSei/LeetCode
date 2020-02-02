package g0.p62不同路径;

import java.math.BigDecimal;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/15 17:31
 * @Author SonnSei
 */
public class Solution1 {
    /**
     * 如果数据范围比较小可以，要不然会溢出
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if(m<1 || n<1)return 0;
        int N = m+n-2;
        int K = m-1;
        int ret = 1;
        return factorial(N) / (factorial(K) * factorial(N - K));
    }

    private int factorial(int n) {
        if(n == 1)return 1;
        return n * factorial(n - 1);
    }
}
