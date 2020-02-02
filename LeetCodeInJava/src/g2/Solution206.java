package g2;

import util.ListNode;

/**
 * @Classname Solution206
 * @Description TODO
 * @Date 2019/12/14 9:48
 * @Created by Jesse
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (head != null) {
            ListNode next = head.next;
            head.next = dummyHead.next;
            dummyHead.next = head;
            head = next;
        }
        return dummyHead.next;
    }
}
