package g1;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution106
 * @Description TODO
 * @Date 2019/12/19 15:47
 * @Author SunCheng
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null)return null;
        TreeNode ret = buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
        return ret;
    }

    private TreeNode buildTree(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd) {
        if(inStart>inEnd || postStart>postEnd)return null;
        int key = post[postEnd];
        TreeNode root = new TreeNode(key);

        for (int i = inEnd; i >=inStart ; i--) {
            if (in[i] == key) {
                root.left = buildTree(in, inStart, i - 1, post, postStart, i-1 - inStart + postStart);
                root.right = buildTree(in, i + 1, inEnd, post, i - inStart + postStart, postEnd - 1);
            }
        }
        return root;
    }


    /************************************************************/
    /***********************    官方题解   ***********************/
    /************************************************************/

    HashMap<Integer,Integer> memo = new HashMap<>();
    int[] post;

    /**
     * 利用HashMap省去了遍历查找的过程
     * @param inorder 中序遍历序列
     * @param postorder 后序遍历序列
     * @return
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++)memo.put(inorder[i], i);

        post = postorder;
        TreeNode root = buildTree2(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    public TreeNode buildTree2(int is, int ie, int ps, int pe) {
        if(ie < is || pe < ps) return null;

        int root = post[pe];
        int ri = memo.get(root);

        TreeNode node = new TreeNode(root);
        node.left = buildTree2(is, ri - 1, ps, ps + ri - is - 1);
        node.right = buildTree2(ri + 1, ie, ps + ri - is, pe - 1);
        return node;
    }

    /************************************************************/
    /********************   自己改写官方题解   ********************/
    /************************************************************/

    /**
     * 利用HashMap优化遍历的时间
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree3(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null)return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1,
                map);
        return root;
    }

    private TreeNode buildTree(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd, Map<Integer, Integer> map) {
        if(inStart>inEnd || postStart>postEnd)return null;
        TreeNode root = new TreeNode(post[postEnd]);
        int mid = map.get(root.val);
        root.left = buildTree(in, inStart, mid - 1, post,postStart , mid - inStart - 1 + postStart, map);
        root.right = buildTree(in, mid + 1, inEnd, post, mid - inStart + postStart, postEnd - 1, map);
        return root;
    }
}
