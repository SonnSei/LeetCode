package g1.p100相同的树;

import util.TreeNode;

/**
 * @Classname Solution2
 * @Description
 * @Date 2020/1/21 18:03
 * @Author SonnSei
 */
public class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q == null)return true;
        if(p==null || q == null)return false;
        if(p.val!=q.val)return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
