package g3.p387字符串中第一个唯一字符;

/**
 * @Classname Solution387
 * @Description 字符串中的第一个唯一字符
 * @Date 2019/12/22 10:00
 * @Author SunCheng
 */
public class Solution387 {
    public int firstUniqChar(String str) {
        if (str == null) return -1;
        int[] arrayMap = new int[128];
        for (int i = 0; i < str.length(); i++) {
            arrayMap[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (arrayMap[str.charAt(i)] == 1)
                return i;
        }
        return -1;
    }
}
