package 树.p116填充每个节点的下一个右侧指针;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/21 21:02
 * @Author SonnSei
 */
public class Solution1 {
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
        if(root == null)return null;
        Node upLevelHeaed;
        Node cur;
        upLevelHeaed = root;
        while (upLevelHeaed.left != null) {
            Node upLevelPoint = upLevelHeaed;
            cur = null;
            while (upLevelPoint != null) {
                if (cur == null) {
                    upLevelPoint.left.next = upLevelPoint.right;
                    cur = upLevelPoint.right;
                } else {
                    cur.next = upLevelPoint.left;
                    upLevelPoint.left.next = upLevelPoint.right;
                    cur  = upLevelPoint.right;
                }
                upLevelPoint = upLevelPoint.next;
            }
            upLevelHeaed = upLevelHeaed.left;
        }
        return root;
    }
}
