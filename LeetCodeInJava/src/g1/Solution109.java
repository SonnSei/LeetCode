package g1;

import util.ListNode;
import util.TreeNode;

import java.util.ArrayList;

/**
 * @Classname Solution109
 * @Description TODO
 * @Date 2019/12/19 16:22
 * @Author SunCheng
 */
public class Solution109 {

    /**
     * 方法一：
     * 转list，然后就和108一样了
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return sortedArrayToBST(list);
    }

    public TreeNode sortedArrayToBST(ArrayList<Integer> nums) {
        if (nums == null) return null;
        TreeNode root = sortedArrayToBST(nums, 0, nums.size() - 1);
        return root;
    }

    private TreeNode sortedArrayToBST(ArrayList<Integer> nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) >>> 1;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }

    /**
     * 方法二：
     * 在链表中取中点
     * @param head
     * @return
     */
    public TreeNode sortedListToBST2(ListNode head) {
        if(head == null)return null;
        return sortedListToBST2(head, null);
    }

    private TreeNode sortedListToBST2(ListNode head, ListNode tail) {
        if(tail == null && head == null)return null;
        if(tail!=null && head.val == tail.val) return null;
       ListNode fast = head,slow = head;
        if (tail == null) {
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
        } else {
            while (fast.val != tail.val && fast.next.val != tail.val) {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST2(head, slow);
        root.right = sortedListToBST2(slow.next, tail);
        return root;
    }
}
