package g2;

import util.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname Solution236
 * @Description 二叉树的最近公共祖先
 * @Date 2019/12/31 13:33
 * @Author SonnSei
 */
public class Solution236 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        Solution236 solution = new Solution236();
        TreeNode ret = solution.lowestCommonAncestor(node1, node2, node3);
        System.out.println(ret==null?null:ret.val);
    }

    /**
     * 我一开始的做法，非常慢
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果p和d分别在一个节点的左右子树中出现，则该节点就是目标节点
        if(root == null)return null;
        if(root.val==p.val||root.val==q.val)
            return containsNode(root,p,q)?root:null;
        boolean left = containsNode(root.left,p,q);
        boolean right = containsNode(root.right,p,q);
        if(left && right) return root;
        if(left) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }

    static boolean hasP;
    static boolean hasQ;
    private boolean containsNode(TreeNode node, TreeNode p, TreeNode q) {
          hasP = false;
          hasQ = false;
        preOrder(node, p, q);
        return hasP||hasQ;
    }

    private void preOrder(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null)return;
        if(node.val==p.val)hasP = true;
        if(node.val == q.val) hasQ=true;
        preOrder(node.left,p,q);
        preOrder(node.right,p,q);
    }


    /**
     * 递归优化，全局遍历存储TreeNode
     * 如果TreeNode已经被赋值，那么就已经是出栈了，不会再有符合赋值条件的情况出现了
     * @param root
     * @param p
     * @param q
     * @return
     */
    static TreeNode ret;
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return ret;
    }

    private boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return false;
        int left = recurseTree(root.left,p,q)?1:0;
        int right = recurseTree(root.right,p,q) ? 1 : 0;
        int mid = (root.val == p.val || root.val == q.val)?1:0;
        if(left+mid+right>=2)ret = root;
        return (left+mid+right)>0;
    }


    /**
     * 字典记录父节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        inOrder(root, map);
        Set<TreeNode> ancestorsOfP = new HashSet<>();
        while (p != null) {
            ancestorsOfP.add(p);
            p = map.get(p);
        }
//        while (q != null) {
//            if(ancestorsOfP.contains(q))return q;
//            q = map.get(q);
//        }
//        return null;

        // 一种更灵性的写法
        while(!ancestorsOfP.contains(q))
            q = map.get(q);
        return q;
    }

    private void inOrder(TreeNode node, Map<TreeNode, TreeNode> map) {
        if(node == null)return;
        inOrder(node.left,map);
        if(node.left!=null)
            map.put(node.left, node);
        if(node.right!=null)
            map.put(node.right, node);
        inOrder(node.right,map);
    }

}
