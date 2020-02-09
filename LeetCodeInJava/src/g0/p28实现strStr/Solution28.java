package g0.p28实现strStr;

/**
 * @Classname Solution28
 * @Description 实现 strStr()
 * @Date 2020/1/7 10:36
 * @Author SonnSei
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        if(needle==null || haystack==null)return -1;
        if(needle.length()==0)return 0;
        return KMP_Sarch(haystack, needle);
    }

    public static int KMP_Sarch(String s, String p) {
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        int[] next = getNext(pChars);
        moveArray(next);
        // text[i]      len   = n
        // pattern[j]   len   = m
        int i = 0, j = 0, n = sChars.length, m = pChars.length;
        while (i < n) {
            if (j == m - 1 && sChars[i] == pChars[j]) {
                // 这个地方 i-j就是找到的索引，如果不继续找，就可以直接返回
                // 如果还继续找，就 j = next[j]
                return i-j;
            }
            if (sChars[i] == pChars[j]) {
                j++;
                i++;
            } else {
                j = next[j];
                if (j == -1) {
                    i++;
                    j++;
                }
            }
        }
        return -1;
    }


    public static int[] getNext(char[] pattern) {
        int m = pattern.length;
        int[] prefix = new int[m];
        prefix[0] = 0;
        int len = 0;
        int i = 1;
        while (i < m) {
            if (pattern[i] == pattern[len]) {
                len++;
                prefix[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = prefix[len - 1];
                } else {
                    prefix[i] = len;
                    i++;
                }
            }
        }
        return prefix;
    }

    private static void moveArray(int[] array) {
        int n = array.length;
        for (int i = n - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = -1;
    }
}
