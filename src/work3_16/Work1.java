package work3_16;

/**
 * Created with IntelliJ IDEA.
 * Description:相同的树
 * https://leetcode-cn.com/problems/same-tree/
 * User: starry
 * Date: 2021 -03 -16
 * Time: 13:27
 */
public class Work1 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null || p !=null && q == null) return false;
        if(p == null && q == null) {
            return true;
        }
        if(p.val != q.val) {
            return false;
        }
        boolean left = isSameTree(p.left,q.left);
        boolean right = isSameTree(p.right,q.right);
        return (left && right);
    }

}
