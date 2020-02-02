package g0;

import util.ListNode;

/**
 * @Classname Solution61
 * @Description 旋转链表
 * @Date 2019/12/11 11:10
 * @Created by Jesse
 */
public class Solution61 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node = new Solution61().rotateRight(node1, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null||head.next==null || k == 0)return head;
        ListNode dummyHead = new ListNode(0);

        int size = getSize(head);
        k = k%size;
        if(k == 0)return head;

        ListNode breakPoint = head;
        ListNode preOfBreakPoint = null;
        for (int i = 0; i < size - k; i++) {
            if(i == size-k-1)
                preOfBreakPoint = breakPoint;
            breakPoint = breakPoint.next;
        }

        dummyHead.next = breakPoint;
        preOfBreakPoint.next = null;
        ListNode cur = breakPoint;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return dummyHead.next;
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
