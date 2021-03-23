package work3_22;

import work3_16.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * User: starry
 * Date: 2021 -03 -22
 * Time: 20:16
 */
public class Work1 {

    //自下向上
    public boolean isBalanced(TreeNode root) {
        if(hight(root) >= 0) return true;
        return false;
    }

    public int hight(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return 1;
        }
        int left = hight(root.left);
        int right = hight(root.right);
        if(left == -1 || right == -1 || Math.abs(left-right) > 1) return -1;
        return Math.max(left,right)+1;
    }

}
