package g0.p61旋转链表;


import util.ListNode;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/15 16:58
 * @Author SonnSei
 */
public class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)return head;
        int size = getSize(head);
        k = k%size;
        if(k==0)return head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode beforeBreadPoint = dummyHead;
        for (int i = 0; i < size - k; i++) {
            beforeBreadPoint = beforeBreadPoint.next;
        }
        ListNode next = beforeBreadPoint.next;
        beforeBreadPoint.next = null;
        dummyHead.next = next;
        while(next.next!=null)
            next = next.next;
        next.next = head;
        return dummyHead.next;
    }

    private int getSize(ListNode head) {
        ListNode cur = head;
        int ret = 0;
        while (cur != null) {
            ret++;
            cur = cur.next;
        }
        return ret;
    }
}
