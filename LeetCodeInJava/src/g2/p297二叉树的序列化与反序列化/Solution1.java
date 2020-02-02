package g2.p297二叉树的序列化与反序列化;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/23 12:11
 * @Author SonnSei
 */
public class Solution1 {
    public static String Serialize(TreeNode root) {
        if(root == null) return "#!";
        StringBuilder ret = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                ret.append("#!");
            } else {
                ret.append(cur.val + "!");
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return ret.toString();
    }
    public static TreeNode Deserialize(String str) {
        String[] values = str.split("!");
        if(values[0].equals("#"))return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i = 1; i < values.length; i+=2) {
            TreeNode cur = queue.poll();
            String leftV = values[i];
            String rightV = values[i+1];
            if (!leftV.equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(leftV));
                cur.left = left;
                queue.add(left);
            }
            if (!rightV.equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(rightV));
                cur.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
