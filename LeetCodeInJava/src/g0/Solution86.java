package g0;

import util.ListNode;

/**
 * @Classname Solution86
 * @Description TODO
 * @Date 2019/12/11 19:06
 * @Created by Jesse
 */
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)return head;
        ListNode dummyHeadBefore = new ListNode(1);
        ListNode curBefore = dummyHeadBefore;
        ListNode dummyHeadAfter = new ListNode(2);
        ListNode curAfter = dummyHeadAfter;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                curBefore.next = node;
                curBefore = curBefore.next;
            } else {
                curAfter.next = node;
                curAfter = curAfter.next;
            }
            node = node.next;
        }
        curAfter.next = null;
        curBefore.next = dummyHeadAfter.next;
        return dummyHeadBefore.next;
    }




}
