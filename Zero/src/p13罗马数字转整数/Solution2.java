package p13罗马数字转整数;

/**
 * @Classname Solution2
 * @Description TODO
 * @Date 2020/1/11 6:53
 * @Author SonnSei
 */
public class Solution2 {
    /**
     * 如果前一个数字比后一个数字小的话，代表发生的特殊情况
     * switch比hashmap还要快
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int ret = 0;
        int preValue = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int curVlue = getValue(c);
            ret +=curVlue;
            if (preValue < curVlue) {
                // IV=4，但是其实算的是I+V=6，所以需要减去两倍的pre
                ret-=preValue<<1;
            }
            preValue = curVlue;
        }
        return ret;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
