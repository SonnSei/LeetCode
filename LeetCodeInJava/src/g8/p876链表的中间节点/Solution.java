package g8.p876链表的中间节点;

import util.ListNode;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/28 17:58
 * @Author SonnSei
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
