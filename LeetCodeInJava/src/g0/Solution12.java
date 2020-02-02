package g0;

/**
 * @Classname Solution12
 * @Description 整数转罗马数字
 * @Date 2019/12/14 15:35
 * @Created by SonnSei
 */
public class Solution12 {
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
