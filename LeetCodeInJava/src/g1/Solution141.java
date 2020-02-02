package g1;

import util.ListNode;

/**
 * @Classname Solution141
 * @Description linked list cycle
 * @Date 2019/12/14 9:36
 * @Created by Jesse
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if(head == null ||head.next == null)return false;
        ListNode slow=head,fast = head;
        slow = slow.next;
        fast = fast.next.next;
        while (fast != null && fast.next!=null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
