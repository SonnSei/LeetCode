package 树.p100相同的树;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/21 18:00
 * @Author SonnSei
 */
public class Solution1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        List<Integer> pIn = new ArrayList<>();
        List<Integer> qIn = new ArrayList<>();
        List<Integer> pPre = new ArrayList<>();
        List<Integer> qPre = new ArrayList<>();

        preOrder(p, pPre);
        preOrder(q, qPre);
        inOrder(p, pIn);
        inOrder(q, qIn);


        return check(pIn,qIn)&&check(pPre,qPre);
    }

    private boolean check(List<Integer> list1, List<Integer> list2) {
        if(list1.size()!=list2.size())return false;
        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i)!=list2.get(i))return false;
        }
        return true;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if(node == null)return;;
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    private void preOrder(TreeNode node, List<Integer> list) {
        if(node == null)return;;
        list.add(node.val);
        preOrder(node.left,list);
        preOrder(node.right, list);
    }
}
