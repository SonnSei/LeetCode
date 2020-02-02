package g0;

import util.ListNode;

/**
 * @Classname Solution83
 * @Description 删除排序链表中的重复元素
 * @Date 2019/12/11 11:27
 * @Created by Jesse
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null ||head.next==null)return head;
        ListNode dummyHead = new ListNode(0);
        ListNode cur = head;
        dummyHead.next = cur;
        while (cur!=null && cur.next != null) {
            cur.next = getNextDifferentNode(cur.next,cur.val);
            cur = cur.next;
        }
        return dummyHead.next;
    }

    private ListNode getNextDifferentNode(ListNode node, int val) {
        while (node != null && node.val == val) {
            node =node.next;
        }
        return node;
    }
}
