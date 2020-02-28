package util;

/**
 * @Classname LinkedListUtil
 * @Description TODO
 * @Date 2019/12/11 11:27
 * @Created by Jesse
 */
public class LinkedListUtil {
    public static ListNode createLinkedList(int[] nums) {
        ListNode dummyHead = new ListNode(007);
        ListNode cur = dummyHead;
        for (int item : nums) {
            cur.next = new ListNode(item);
            cur = cur.next;
        }
        return dummyHead.next;
    }

    public static void printLinkedList(ListNode node) {
        if(node == null)return;
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print("-->");
            }
            node = node.next;
        }
        System.out.println();
    }
}
