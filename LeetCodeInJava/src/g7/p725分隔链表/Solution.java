package g7.p725分隔链表;

import util.LinkedListUtil;
import util.ListNode;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/28 17:04
 * @Author SonnSei
 */
public class Solution {
    public static void main(String[] args) {
        ListNode root = LinkedListUtil.createLinkedList(new int[]{1, 2, 3});
        ListNode[] listNodes = splitListToParts(root, 2);
//        for (ListNode node : listNodes) {
//            LinkedListUtil.printLinkedList(node);
//        }
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] array = new ListNode[k];
        if(root==null)return array;
        int size = getSize(root);
        int segmentSize = size/k;
        int plus = segmentSize==0?0:size-segmentSize*k;
        //if(size%k!=0)segmentSize++;
        int index = 0;
        ListNode cur = root;
        ListNode head=null;
        ListNode next = null;
        while (cur != null) {
            head = cur;
            for (int i = 0; i < segmentSize-1; i++) {
                if(cur.next==null)break;
                cur = cur.next;

            }
            if (plus > 0 && cur.next!=null) {
                cur = cur.next;
                plus--;
            }
            next = cur.next;
            cur.next=null;
            LinkedListUtil.printLinkedList(head);
            array[index++]=head;
            cur = next;
        }
        return array;
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
