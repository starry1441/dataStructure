package work3_24;

import work3_16.TreeNode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -03 -24
 * Time: 16:50
 */
public class Work1 {

    // 前序遍历---非递归
    void preOrderTraversalNor(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.println(cur.val + " ");
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            cur = top.right;
        }
        System.out.println();
    }

    // 中序遍历---非递归
    void inOrderTraversalNor(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.pop();
            System.out.println(top.val + " ");
            cur = top.right;
        }
        System.out.println();
    }

    // 后序遍历---非递归
    void postOrderTraversalNor(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if(top.right == null || top.right == prev) {
                stack.pop();
                System.out.println(top.val + " ");
                prev = top;
            }else {
                cur = top.right;
            }
        }
        System.out.println();
    }

}
