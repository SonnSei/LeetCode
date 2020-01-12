package p8字符串转整数;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/10 18:12
 * @Author SonnSei
 */
public class Solution1 {
    public static int myAtoi(String str) {
        if (str == null || (str = str.trim()).length() == 0) return 0;
        boolean negative = false;
        char c = str.charAt(0);
        if(c=='-')
            negative = true;
        else if(c=='+')
            str = str.substring(1);
        else if(!Character.isDigit(c))
            return 0;

        int ret = 0;
        for (int i = negative?1:0; i <str.length() ; i++) {
            c = str.charAt(i);
            if(!Character.isDigit(c))break;
            // 注意对负数的处理---加了负号和括号
            if(negative && (ret>-(Integer.MIN_VALUE/10) || (ret ==-(Integer.MIN_VALUE/10) && c>'8')))return Integer.MIN_VALUE;
            if(!negative && (ret>Integer.MAX_VALUE/10 || (ret == Integer.MAX_VALUE/10 && c>'7')))return Integer.MAX_VALUE;
            ret*=10;
            ret+=c-'0';
        }
        return negative?-ret:ret;
    }
}
