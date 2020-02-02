package g0;

import util.LinkedListUtil;
import util.ListNode;

/**
 * @Classname Solution92
 * @Description 链表反转2
 * @Date 2019/12/11 19:40
 * @Created by Jesse
 */
public class Solution92 {

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createLinkedList(new int[]{1,2,3, 4,5});
        head = new Solution92().reverseBetween(head, 2, 4);
        LinkedListUtil.printLinkedList(head);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        ListNode node = head;
        // 第m个node的索引是m-1，意味着前m-1个元素是不需要改变顺序的
        for (int i = 0; i < m-1; i++) {
            cur.next = node;
            cur = cur.next;
            node = node.next;
        }
        // 此时cur指向的是反转区间的前一个元素，
        // 从m到n一共有n-m+1个元素，所以从cur移动n-m+2次，刚好可以移动到反转区间的后一个元素
        ListNode next = cur;
        // 如果是从第一个位置开始反转，那么cur与链表则尚未形成联系
        if(cur.next==null)cur.next = head;
        for (int i = 0; i < n-m+2; i++) {
            next = next.next;
        }
        cur.next = reverseSection(cur.next, n-m+1);
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = next;
        return dummyHead.next;
    }

    // 对以node为head，取count个node反转
    private ListNode reverseSection(ListNode node, int count) {
        ListNode dummyHead = new ListNode(0);
        int i = 0;
        while (i<count) {
            ListNode next = node.next;
            node.next = dummyHead.next;
            dummyHead.next = node;
            node = next;
            i++;
        }
        return dummyHead.next;
    }
}
