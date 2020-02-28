package g4.p445两数相加Ⅱ;

import util.ListNode;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/28 16:33
 * @Author SonnSei
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size1 = getSize(l1);
        int size2 = getSize(l2);
        int diff = Math.abs(size1 - size2);
        ListNode dummyHead1 = new ListNode(0);
        ListNode cur1 = dummyHead1;
        ListNode dummyHead2 = new ListNode(0);
        ListNode cur2 = dummyHead2;

        for (int i = 0; i < diff; i++) {
            cur1.next = new ListNode(0);
            cur1 = cur1.next;
        }

        if (size1 < size2) {
            cur1.next = l1;
            cur2.next = l2;
        } else {
            cur1.next = l2;
            cur2.next = l1;
        }

        ListNode ret = addNode(dummyHead1.next, dummyHead2.next);
        if (ret.val >= 10) {
            ListNode node = new ListNode(1);
            ret.val%=10;
            node.next = ret;
            return node;
        }
        return ret;
    }

    private static ListNode addNode(ListNode node1, ListNode node2) {
        if (node1.next == null && node2.next == null) {
            return new ListNode(node1.val + node2.val);
        }
        ListNode next = addNode(node1.next, node2.next);
        ListNode ret = new ListNode(node1.val + node2.val + next.val / 10);
        next.val %= 10;
        ret.next = next;
        return ret;
    }

    private static int getSize(ListNode node) {
        int ret = 0;
        while (node != null) {
            ret++;
            node = node.next;
        }
        return ret;
    }
}
