package g11.p1175质数排列;

import java.math.BigDecimal;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/8 20:01
 * @Author SonnSei
 */
public class Solution {
    public int numPrimeArrangements(int n) {
        if(n<2)return 0;
        boolean[] dp = new boolean[n+1];
        dp[0]=true;
        dp[1]= true;
        for(int i = 2;i*i<=n;i++){
            if(dp[i])continue;
            int j = i*2;
            while(j<=n){
                dp[j] = true;
                j+=i;
            }
        }
        int cnt = 0;
        for(boolean val:dp){
            if(!val)cnt++;
        }
        long ret = 1;
        for(int i = 1;i<=cnt;i++){
            ret*=i;
            ret%=100000007;
        }
        long mul = 1;
        for(int i = 1;i<=n-cnt;i++){
            mul*=i;
            mul%=100000007;
        }
        BigDecimal a = new BigDecimal(ret);
        BigDecimal b = new BigDecimal(mul);

        return (int)((ret*mul)%1000000007);
    }
}
