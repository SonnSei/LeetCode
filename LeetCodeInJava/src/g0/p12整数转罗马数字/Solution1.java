package g0.p12整数转罗马数字;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/11 6:35
 * @Author SonnSei
 */
public class Solution1 {
    public String intToRoman(int num) {
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            int count = num / value[i];
            for (int j = 0; j < count; j++) {
                ret.append(strs[i]);
            }
            num -= count * value[i];
        }
        return ret.toString();
    }
}
