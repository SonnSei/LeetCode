package g2;

import java.util.Arrays;

/**
 * @Classname Solution204
 * @Description TODO
 * @Date 2019/12/31 10:54
 * @Author SonnSei
 */
public class Solution204 {
    public static void main(String[] args) {
        System.out.println(countPrimes1(100));
    }

    public static int countPrimes1(int n) {
        if (n < 2) return 0;
        int ret = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) ret++;
        }
        return ret;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }


    public static int countPrimes2(int n) {
        if (n < 2) return 0;
        boolean[] dp = new boolean[n];
        Arrays.fill(dp, true);
        for (int i = 2; i < n; i++) {
            if (!dp[i]) continue;
            int j = i * 2;
            while (j < n) {
                dp[j] = false;
                j += i;
            }
        }
        int count = 0;
        for (boolean item : dp) {
            if (item) count++;
        }
        return count;
    }

    public static int countPrimes(int n) {
        // 注意求的是小于n的
        if (n < 2) return 0;
        boolean[] dp = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (dp[i]) continue;
            int j = i * i;
            while (j < n) {
                dp[j] = true;
                j += i;
            }
        }
        int count = 0;
        for (boolean item : dp) {
            if (!item) count++;
        }
        return count - 2;
    }




}
