package g0.p32最长有效括号;

import java.util.Stack;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/2/9 16:24
 * @Author SonnSei
 */
public class Solution2 {

    public int longestValidParentheses(String s) {
        // 思路是 没遇到一对（），我们取到（前面的索引来判断此时有效长度
        // 如果没有与）对应的（，则此时应该是一段有效长度结束了
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
