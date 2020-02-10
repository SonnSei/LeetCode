package g0.p43字符串相乘;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/10 11:12
 * @Author SonnSei
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if(num1==null || num2==null) return "";
        if(num1.length()==0||num2.length()==0) return "";
        if("0".equals(num1)||"0".equals(num2)) return "0";
        int[] dp = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int v1 = num1.charAt(i) - '0';
                int v2 = num2.charAt(j) - '0';
                dp[i+j]+=v1*v2;
            }
        }

        for(int i = dp.length-1;i>0;i--){
            dp[i-1]+=dp[i]/10;
            dp[i]%=10;
        }
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < dp.length-1; i++) {
            ret.append(dp[i]);
        }
        int begin =0;
        while(begin<ret.length() && ret.charAt(begin)=='0')begin++;
        return ret.toString().substring(begin);
    }
}
