package g2.p297二叉树的序列化与反序列化;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/23 17:15
 * @Author SonnSei
 */
public class Solution2 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;

        String str = serialize(node1);
        TreeNode node = deserialize(str);
        System.out.println(str);
    }

    public static String serialize(TreeNode root) {
        StringBuilder ret = new StringBuilder();
        preOrder(root, ret);
        return ret.toString();
    }

    private static void preOrder(TreeNode node, StringBuilder ret) {
        if (node == null) {
            ret.append("#!");
            return;
        } else {
            ret.append(node.val + "!");
        }
        preOrder(node.left,ret);
        preOrder(node.right,ret);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String str) {
        String[] values = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String item : values) {
            queue.add(item);
        }
        return deserialize(queue);
    }

    private static TreeNode deserialize(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode root= new TreeNode(Integer.parseInt(value));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}
