package g1.p117填充每一个节点的下一个右侧节点指针Ⅱ;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/1/21 21:15
 * @Author SonnSei
 */
public class Solution {
    static class Node {
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

    public static Node connect(Node root) {
        if (root == null) return root;
        Node firstLevelHead = root;
        Node firstLevelPoint ;
        Node secondLevelHead = null;
        Node cur ;
        while (firstLevelHead != null) {
            firstLevelPoint = firstLevelHead;
            // 这个忘记过一次
            secondLevelHead = null;
            cur = null;
            while (firstLevelPoint != null) {
                if (firstLevelPoint.left != null) {
                    if (cur == null) {
                        cur = firstLevelPoint.left;
                    } else {
                        cur.next = firstLevelPoint.left;
                        cur = firstLevelPoint.left;
                    }
                }
                // 这里也要判断一次，保证cur第一次初始化的时候，secondLevelHead就会被初始化
                if (secondLevelHead == null && cur != null) {
                    secondLevelHead = cur;
                }
                if (firstLevelPoint.right != null) {
                    if (cur == null) {
                        cur = firstLevelPoint.right;
                    } else {
                        cur.next = firstLevelPoint.right;
                        cur = firstLevelPoint.right;
                    }
                }
                if (secondLevelHead == null && cur != null) {
                    secondLevelHead = cur;
                }
                firstLevelPoint = firstLevelPoint.next;
            }
            firstLevelHead = secondLevelHead;
        }
        return root;
    }
}
