package g0.p20有效的括号;

import java.util.Stack;

/**
 * @Classname Solution20
 * @Description Valid Parentheses
 * @Date 2019/12/14 12:46
 * @Created by SunCheng
 */
public class Solution20 {

    public boolean isValid(String s) {
        if(s == null || s.length() ==0)return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' || c == ']' || c == '}') {
                if (c == ')' && (stack.isEmpty() || stack.peek() != '(')) {
                    return false;
                }

                if (c == ']' && (stack.isEmpty() || stack.peek() != '[')) {
                    return false;
                }

                if (c == '}' && (stack.isEmpty() || stack.peek() != '{')) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
