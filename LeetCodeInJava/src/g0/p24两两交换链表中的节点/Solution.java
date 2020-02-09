package g0.p24两两交换链表中的节点;

import util.ListNode;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/2 12:16
 * @Author SonnSei
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(110);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode nextHead = cur.next.next.next;
            ListNode nextNode = cur.next;
            cur.next = nextNode.next;
            cur.next.next = nextNode;
            nextNode.next = nextHead;
            cur = nextNode;
        }
        return dummyHead.next;
    }
}
