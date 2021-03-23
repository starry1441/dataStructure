package work3_22;

import work3_16.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * User: starry
 * Date: 2021 -03 -22
 * Time: 21:28
 */
public class Work2 {

    //自上向下
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = hight(root.left);
        int right = hight(root.right);

        return Math.abs(left-right) <= 1&&isBalanced(root.left)&&isBalanced(root.right);
    }

    public int hight(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return 1;
        }
        int left = hight(root.left);
        int right = hight(root.right);
        int max = Math.max(left,right);
        return max+1;
    }

}
