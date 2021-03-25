package work3_25;

import work3_16.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * User: starry
 * Date: 2021 -03 -25
 * Time: 10:25
 */
public class Work2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null) {
            return root;
        }
        if(left != null) {
            return left;
        }
        if(right != null) {
            return right;
        }

        return null;
    }
    public List<TreeNode> createTree() {
        List<TreeNode> list = new ArrayList<>();
        TreeNode cur3 = new TreeNode(3);
        TreeNode cur5 = new TreeNode(5);
        TreeNode cur1 = new TreeNode(1);
        TreeNode cur6 = new TreeNode(6);
        TreeNode cur2 = new TreeNode(2);
        TreeNode cur0 = new TreeNode(0);
        TreeNode cur8 = new TreeNode(8);
        TreeNode cur4 = new TreeNode(4);
        TreeNode cur7 = new TreeNode(7);
        cur3.left = cur5;
        cur3.right = cur1;
        cur5.left = cur6;
        cur5.right = cur2;
        cur2.left = cur7;
        cur2.right = cur4;
        cur1.left = cur0;
        cur1.right = cur8;
        list.add(cur3);
        list.add(cur5);
        list.add(cur6);
        return list;
    }

    public static void main(String[] args) {
        Work2 a = new Work2();
        List<TreeNode> list = a.createTree();
        TreeNode res = a.lowestCommonAncestor(list.get(0),list.get(1),list.get(2));
    }
}
