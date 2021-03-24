package work3_23;


import work3_16.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * User: starry
 * Date: 2021 -03 -23
 * Time: 20:30
 */
public class Work1 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if(root == null) return out;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> in = new ArrayList<>();
            boolean join1 = false;
            while (!queue1.isEmpty()) {
                join1 = true;
                TreeNode cur = queue1.poll();
                in.add(cur.val);
                if(cur.left != null) {
                    queue2.offer(cur.left);
                }
                if(cur.right != null) {
                    queue2.offer(cur.right);
                }
            }
            if (join1) {
                out.add(in);
                continue;
            }
            while (!queue2.isEmpty()) {
                TreeNode cur = queue2.poll();
                in.add(cur.val);
                if(cur.left != null) {
                    queue1.offer(cur.left);
                }
                if(cur.right != null) {
                    queue1.offer(cur.right);
                }
            }
            out.add(in);
        }
        return out;
    }

}
