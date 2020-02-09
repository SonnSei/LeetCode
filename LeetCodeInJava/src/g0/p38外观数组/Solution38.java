package g0.p38外观数组;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Solution38
 * @Description TODO
 * @Date 2020/1/5 16:34
 * @Author SonnSei
 */
public class Solution38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    /**
     * 队列
     * @param n
     * @return
     */
    public static String countAndSay2(int n) {
        Queue<Character> queue = new LinkedList<>();
        queue.add('1');
        for (int i = 1; i < n; i++) {
            int size = queue.size();
            int j = 0;
            while (j < size) {
                int cnt = 1;
                char c = queue.poll();
                j++;
                while (j < size && queue.peek() == c  ) {
                    queue.poll();
                    cnt++;j++;
                }
                String s = cnt + "";
                for (int k = 0; k < s.length(); k++) {
                    queue.add(s.charAt(k));
                }
                queue.add(c);
            }

            System.out.println(queue);
        }
        StringBuilder ret = new StringBuilder();
        while (!queue.isEmpty()) {
            ret.append(queue.poll());
        }
        return ret.toString();
    }


    /**
     * 递归
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        if (n == 1) {
            return "1";
        }//递归出口
        String preString = countAndSay(n - 1);//前面一个的结果
        for (int i = 0; i < preString.length(); i++) {
            char startNum = preString.charAt(i);
            int nums = 1;
            while (i + 1 < preString.length() && preString.charAt(i + 1) == startNum) {
                nums ++;
                i ++;
            }//相同就累计并递增下标
            stringBuilder.append(nums).append(startNum);
        }
        return stringBuilder.toString();
    }
}
