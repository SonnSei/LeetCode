package zero;

/**
 * @Classname Solution8
 * @Description 字符串转整数
 * @Date 2019/12/9 9:53
 * @Created by Jesse
 */
public class Solution8 {
    public int myAtoi(String str) {
        if (str == null) return 0;
        str = str.trim();
        if (str.length() == 0) return 0;
        char c = str.charAt(0);
        boolean minus = false;
        if (c == '+')
            str = str.substring(1);
        else if (c == '-')
            minus = true;
        else if (c < '0' || c > '9')
            return 0;
        int ret = 0;
        for (int i = minus ? 1 : 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c < '0' || c > '9') break;
            if (!minus && (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && c > '7'))
                return Integer.MAX_VALUE;
            if (minus && (ret > -(Integer.MIN_VALUE / 10) || ret == -(Integer.MIN_VALUE / 10) && c > '8'))
                return Integer.MIN_VALUE;
            ret *= 10;
            ret += c - '0';
        }
        return minus ? -ret : ret;
    }
}
