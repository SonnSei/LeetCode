package g0.p25K个一组反转链表;

import util.ListNode;

/**
 * @Classname Solution25
 * @Description K个一组反转链表
 * @Date 2019/12/11 11:03
 * @Created by Jesse
 */
public class Solution25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(007);
        ListNode cur = dummyHead;
        cur.next = head;
        ListNode start = null;
        ListNode end = null;
        while (cur != null) {
            start = cur.next;
            end = cur;
            for (int i = 0; i < k; i++) {
                if(end==null)
                    break;
                end = end.next;
            }
            if(end == null)break;
            ListNode next= end.next;
            cur.next = reverseList(start,k);
            start.next = next;
            cur = start;
        }
        return dummyHead.next;
    }

    private static ListNode reverseList(ListNode head,int k) {
        ListNode dummyHead = new ListNode(007);
        dummyHead.next =null;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = dummyHead.next;
            dummyHead.next = cur;
            cur = next;
        }
        return dummyHead.next;
    }
}
