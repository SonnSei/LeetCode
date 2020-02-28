package g1.p143重排链表;

import util.LinkedListUtil;
import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/28 12:53
 * @Author SonnSei
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createLinkedList(new int[]{1, 2, 3, 4, 5});
        reorderList(head);
        LinkedListUtil.printLinkedList(head);
    }

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        //存到 list 中去
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        //头尾指针依次取元素
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            //偶数个节点的情况，会提前相遇
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}
