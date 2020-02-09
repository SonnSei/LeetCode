package g0.p19删除链表的倒数第N个节点;

import util.ListNode;

/**
 * @Classname Solution19
 * @Description Remove Nth Node From End of List
 * @Date 2019/12/14 9:54
 * @Created by Jesse
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 为什么不从头节点开始？因为万一要删除的是头节点，那就没法处理了
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slow =dummyHead,fast = dummyHead;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
