package g10.p1019链表中下一个更大节点;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/2/5 15:52
 * @Author SonnSei
 */
public class Solution2 {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        ListNode cur = head;
        while (cur != null) {
            while (!stack.isEmpty() && list.get(stack.peek()) < cur.val) {
                list.set(stack.peek(), cur.val);
                stack.pop();
            }
            stack.push(index);
            list.add(cur.val);
            index++;
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            list.set(stack.pop(), 0);
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
