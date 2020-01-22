package 树.p145二叉树的后序遍历;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Morris
 * @Description
 * @Date 2020/1/22 10:43
 * @Author SonnSei
 */
public class Morris {
    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;

        TreeNode dummyRoot = new TreeNode(-1);
        dummyRoot.left = root;

        TreeNode cur = dummyRoot;
        while(cur != null){
            if(cur.left == null)
                cur = cur.right;
            else{
                TreeNode pre = cur.left;
                while(pre.right != null && pre.right != cur)
                    pre = pre.right;

                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }
                else{
                    pre.right = null;
                    reverseTraversal(cur.left, res);
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    private void reverseTraversal(TreeNode node, ArrayList<Integer> res){
        int start = res.size();
        while(node != null){
            res.add(node.val);
            node = node.right;
        }

        int i = start, j = res.size() - 1;
        while(i < j){
            Integer t = res.get(i);
            res.set(i, res.get(j));
            res.set(j, t);

            i ++;
            j --;
        }
    }
}
