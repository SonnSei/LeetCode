package g0.p2两数相加;


import util.ListNode;

/**
 * @Classname Solution2
 * @Description 两数相加
 * @Date 2019/12/9 8:23
 * @Created by SunCheng
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null || l2 != null) {
            int v1 = l1==null?0:l1.val;
            int v2 = l2 == null?0:l2.val;
            cur.next = new ListNode((v1 + v2 + carry) % 10);
            cur = cur.next;
            carry = (v1+v2+carry)/10;
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
