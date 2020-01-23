package 树.p426将二叉树转化为排序的双向链表;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/23 20:57
 * @Author SonnSei
 */
public class Solution1 {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node4.left = node2;
        node4.right = node5;
        node2.left = node1;
        node2.right = node3;

        Node node = new Solution1().treeToDoublyList(node4);
        while (node != null) {
            System.out.println(node.val);
            node = node.right;
        }
    }

    Node head;
    Node tail;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        inOrder(root);
        tail.right = head;
        head.left = tail;
        return head;

    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.right = node;
            node.left = tail;
            tail = tail.right;
        }
        inOrder(node.right);
    }
}
