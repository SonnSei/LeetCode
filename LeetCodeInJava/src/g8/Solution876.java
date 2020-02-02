package g8;

import util.ListNode;

/**
 * @Classname Solution876
 * @Description middle of the linked list
 * @Date 2019/12/14 10:07
 * @Created by SunCheng
 */
public class Solution876 {
    public ListNode middleNode(ListNode head) {
        if(head == null)return null;
        ListNode fast = head,slow = head;
        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
