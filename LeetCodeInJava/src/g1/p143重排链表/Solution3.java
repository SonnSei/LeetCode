package g1.p143重排链表;

import util.LinkedListUtil;
import util.ListNode;

/**
 * @Classname Solution3
 * @Description
 * @Date 2020/2/28 13:35
 * @Author SonnSei
 */
public class Solution3 {

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createLinkedList(new int[]{1, 2, 3,4});
        reorderList(head);
        LinkedListUtil.printLinkedList(head);
    }

    public static void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        head2 = reverse(head2);
        LinkedListUtil.printLinkedList(head);
        LinkedListUtil.printLinkedList(head2);
        merge(head, head2);

    }

    private static void merge(ListNode node1, ListNode node2) {
        ListNode next1;
        ListNode next2;
        while (node1 != null && node2 != null) {
            next1 = node1.next;
            next2 =node2.next;
            node1.next = node2;
            node2.next = next1;

            node1 = next1;
            node2 = next2;
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
