package g0.p82删除排序链表中的重复元素Ⅱ;

import util.LinkedListUtil;
import util.ListNode;

/**
 * @Classname Solution82
 * @Description TODO
 * @Date 2019/12/11 17:45
 * @Created by Jesse
 */
public class Solution82 {
    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createLinkedList(new int[]{1, 2, 2});
        ListNode newHead = new Solution82().deleteDuplicates2(head);
        LinkedListUtil.printLinkedList(newHead);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        ListNode next = getNext(head);
        while (next != null) {
            cur.next = next;
            cur = cur.next;
            next = getNext(cur.next);
        }
        // 从尾部截断
        // 遇到[1,2,2]这种情况的时候，如果不阶段，返回的是1，但是1后面还链接着2
        cur.next = null;
        return dummyHead.next;
    }

    // 从以node为head的链表中返回第一个只出现一次的node，如果没有，就返回null
    private ListNode getNext(ListNode node) {
        if (node == null || node.next == null || node.val != node.next.val) return node;
        while (node.next != null && node.val == node.next.val) {
            node = node.next;
        }
        return getNext(node.next);
    }

    /**
     * 将方法1中的两个步骤合并到一个方法中
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                while (node.next != null && node.val == node.next.val) {
                    node = node.next;
                }
                node = node.next;
            } else {
                cur.next = node;
                cur = cur.next;
                // 每次添加元素到链表的时候时候，将元素的next置为null
                ListNode next = node.next;
                cur.next = null;
                node = next;
            }
        }
        return dummyHead.next;
    }
}
