package g5;

/**
 * @Classname Solution509
 * @Description 斐波那契
 * @Date 2019/12/25 15:54
 * @Author Cheng
 */
public class Solution509 {
    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    public static int fib(int n) {
        return tailRecursion(n, 0, 1);
    }

    public static  int tailRecursion(int n, int ret1, int ret2) {
        if (n == 0) {
            return ret1;
        }
        return tailRecursion(n - 1, ret2, ret1 + ret2);
    }


    long memoFromTop(int n) {
        if (n < 1) {
            return 0;
        }
        int[] memo = new int[n + 1];//让数组的索引与数列索引同步起来所以用的n+1
        for (int i = 0; i < n + 1; i++) {
            memo[i] = -1;
        }
        return getFromTopMemo(n, memo);
    }

    private int getFromTopMemo(int n, int[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n <= 2) {
            memo[n] = 1;
        } else {
            memo[n] = getFromTopMemo(n - 1, memo) + getFromTopMemo(n - 2, memo);
        }
        return memo[n];
    }
}
