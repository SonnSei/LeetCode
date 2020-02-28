package g1.p147对链表进行插入排序;

import util.LinkedListUtil;
import util.ListNode;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/28 15:40
 * @Author SonnSei
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createLinkedList(new int[]{2, 3, 1, 4});
        LinkedListUtil.printLinkedList(insertionSortList(head));
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = head;
        ListNode next;
        ListNode preNode=null;
        while (cur != null) {
            next = cur.next;
            if (preNode == null || cur.val < preNode.val) {
                insertFromNode(dummyHead, cur);
            } else {
                insertFromNode(preNode,cur);
            }
            preNode = cur;
            cur = next;
        }
        return dummyHead.next;
    }

    private static void insertFromNode(ListNode point, ListNode cur) {
        while (point.next!=null && point.next.val < cur.val) {
            point = point.next;
        }
        cur.next = point.next;
        point.next = cur;
    }
}
