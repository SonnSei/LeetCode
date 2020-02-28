package g4.p430扁平化多级双向链表;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/28 16:11
 * @Author SonnSei
 */
public class Solution {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        if(head==null)return null;
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        Node dummyHead = new Node();
        Node point = dummyHead;
        Node child = null;
        while (cur != null) {
            point.next = cur;
            cur.prev = point;
            point = point.next;
            if (cur.child != null) {
                stack.push(cur.next);
                child = cur.child;
                cur.child=null;
                cur = child;
            } else if (cur.next != null) {
                cur = cur.next;
            } else {
                cur = stack.isEmpty()?null:stack.pop();
            }
        }
        dummyHead.next.prev = null;
        return  dummyHead.next;
    }
}
