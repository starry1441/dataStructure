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
 * Time: 21:31
 */
public class Work2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if(root == null) return out;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> in = new ArrayList<>();
            int size = queue.size();
            while(size > 0) {
                TreeNode cur = queue.poll();
                in.add(cur.val);
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
                size--;
            }
            out.add(in);
        }
        return out;
    }

}
