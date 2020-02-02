package g1;

/**
 * @Classname Solution116
 * @Description TODO
 * @Date 2020/1/9 17:49
 * @Author SonnSei
 */
public class Solution116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public Node connect(Node root) {
        if (root == null) return null;
        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public Node connect2(Node root) {
        if (root == null) return root;
        Node head = root;
        Node cur = head;
        // 这个地方如果判断条件是（cur!=null）为什么不可以？
        // 因为题目给出的是完美二叉树，我们不必遍历最后一层，而且最后一层一定是没有左右子树的
        while (head.left != null) {
            cur = head;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            head = head.left;
        }
        return root;
    }
}
