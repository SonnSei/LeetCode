package g2;

/**
 * @Classname Solution263
 * @Description TODO
 * @Date 2019/12/22 9:33
 * @Author SunCheng
 */
public class Solution263 {
    public static void main(String[] args) {
        System.out.println(isUgly(7));
    }

    public static boolean isUgly(int num) {
        if(num == 0)return false;
        while (num != 1) {
            if (num % 2 == 0) {
                num/=2;
                continue;
            }
            if (num % 3 == 0) {
                num/=3;
                continue;
            }
            if (num % 5 == 0) {
                num/=5;
                continue;
            }
            return false;
        }
        return true;
    }
}
