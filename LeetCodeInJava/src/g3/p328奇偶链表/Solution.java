package g3.p328奇偶链表;

import jdk.nashorn.internal.ir.LiteralNode;
import util.LinkedListUtil;
import util.ListNode;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/28 12:25
 * @Author SonnSei
 */
public class Solution {
    public static void main(String[] args) {
        ListNode root = LinkedListUtil.createLinkedList(new int[]{1,2,3});
        root = oddEvenList(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode cur = head.next.next;
        ListNode pre1 = head;
        ListNode pre2 = head.next;
        pre2.next=null;
        boolean turn = true;
        while (cur != null) {
            ListNode next = cur.next;
            // 奇数
            if (turn) {
                cur.next = pre1.next;
                pre1.next = cur;
                pre1 = pre1.next;
            } else {
                pre2.next = cur;
                pre2 = pre2.next;
                pre2.next=null;
            }
            cur = next;
            turn = !turn;
        }
       return head;
    }
}
