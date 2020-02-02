package g2.p255验证前序遍历序列二叉树;

/**
 * @Classname Solution1
 * @Description
 * @Date 2020/1/22 22:46
 * @Author SonnSei
 */
public class Solution1 {
    public static void main(String[] args) {
        boolean ret = verifyPreorder(new int[]{5, 2, 6, 1, 3});
        System.out.println(ret);

    }

    public static boolean verifyPreorder(int[] preorder) {
        if(preorder == null)return false;
        return verifyPreorder(preorder, 0, preorder.length - 1);
    }

    private static boolean verifyPreorder(int[] preorder, int start, int end) {
        if(start >= end)return true;
        int rootValue = preorder[start];
        int index = start+1;
        // while循环一定要注意越界问题
        while (index<preorder.length && preorder[index] < rootValue) {
            index++;
        }
        for (int i = index;i<=end;i++) {
            if(preorder[i]<=rootValue)
                return false;
        }
        return verifyPreorder(preorder, start + 1, index - 1) && verifyPreorder(preorder, index, end);
    }
}
