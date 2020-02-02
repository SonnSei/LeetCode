package g0;

import util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname Solution23
 * @Description TODO
 * @Date 2019/12/11 11:08
 * @Created by Jesse
 */
public class Solution23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        boolean allNull = true;
        int point = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                allNull = false;
                if (lists[i].val < min) {
                    point = i;
                    min = lists[i].val;
                }
            }
        }
        if(allNull)return null;
        ListNode ret = lists[point];
        lists[point] = lists[point].next;
        ret.next = mergeKLists(lists);
        return ret;
    }

    //优先队列
    public static ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node :
                lists) {
            if(node!=null)
                priorityQueue.add(node);
        }
        ListNode dummyHead = new ListNode(110);
        ListNode cur = dummyHead;
        while (!priorityQueue.isEmpty()) {
            ListNode temp = priorityQueue.poll();
            cur.next = temp;
            if(temp.next!=null)
                priorityQueue.add(temp.next);
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
