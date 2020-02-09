package g10.p1019链表中下一个更大节点;

import util.ListNode;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/5 15:35
 * @Author SonnSei
 */
public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if(head == null )return null;
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int[] ret = new int[size];
        int index = 0;
        cur = head;
        while (cur != null) {
            ret[index++]=cur.val;
            cur = cur.next;
        }

        for (int i = 0; i < ret.length; i++) {
            boolean flag = false;
            for (int j = i+1; j <ret.length ; j++) {
                if (ret[j] > ret[i]) {
                    ret[i] = ret[j];
                    flag = true;
                    break;
                }
            }
            if(!flag){
                ret[i] = 0;
            }
        }
        return ret;
    }
}
