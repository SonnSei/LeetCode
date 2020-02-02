package g1;

/**
 * @Classname Solution115
 * @Description 不同的子序列
 * @Date 2019/12/20 9:03
 * @Author SunCheng
 */
public class Solution115 {

    public static void main(String[] args) {
        int i = numDistinct("babgbag", "bag");
        System.out.println(i);
    }
    public static int numDistinct(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if(lenS<lenT)return 0;
        int ret = 1;
        int indexS = 0;
        for (int i = 0; i < lenT; i++) {
            int cnt = 0;
            char c = t.charAt(i);
            while (indexS<lenS&&s.charAt(indexS) == c ) {
                cnt++;
                indexS++;
            }
            ret*=Math.max(cnt,1);
        }
        return ret;

    }
}
