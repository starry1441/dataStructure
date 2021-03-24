package work3_24;

import work3_16.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -03 -24
 * Time: 17:05
 */
public class Work2 {

    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur == null) {
                break;
            }else {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        while(!queue.isEmpty()) {
            if(cur != null) return false;
            TreeNode cur = queue.poll();
        }
        return true;
    }

}
