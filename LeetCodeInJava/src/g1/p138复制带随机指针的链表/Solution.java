package g1.p138复制带随机指针的链表;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/28 12:46
 * @Author SonnSei
 */
public class Solution {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Node cur = head;
        while (cur != null) {
            Node next = new Node(cur.val);
            next.next = cur.next;
            cur.next = next;
            cur = next.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        Node dummyHead = new Node(0);
        Node point = dummyHead;
        cur = head;
        while (cur != null) {
            Node node = cur.next;
            cur.next = node.next;
            cur = cur.next;
            node.next=null;
            point.next = node;
            point = point.next;
        }
        return dummyHead.next;
    }
}
