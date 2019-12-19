import One.Solution104;
import One.Solution109;
import One.Solution112;
import util.ListNode;
import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import static util.LinkedListUtil.createLinkedList;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/12/18 19:22
 * @Created by SunCheng
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        Solution112 solution = new Solution112();
        System.out.println(solution.hasPathSum3(root,2));
    }


}
