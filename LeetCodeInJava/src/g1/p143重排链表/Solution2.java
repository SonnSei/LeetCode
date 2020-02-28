package g1.p143重排链表;

import util.LinkedListUtil;
import util.ListNode;

import java.io.LineNumberReader;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/2/28 13:21
 * @Author SonnSei
 */
public class Solution2 {
    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createLinkedList(new int[]{1, 2, 3, 4, 5});
        reorderList(head);
        LinkedListUtil.printLinkedList(head);
    }

    public static void reorderList(ListNode head) {
        while (head != null) {
            head.next = reverse(head.next);
            head = head.next;
        }
    }

    private static ListNode reverse(ListNode node) {
        ListNode dummyHead = new ListNode(0);
        ListNode next;
        while (node != null) {
            next = node.next;
            node.next = dummyHead.next;
            dummyHead.next = node;
            node = next;
        }
        return dummyHead.next;
    }


}
