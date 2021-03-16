package work3_16;

/**
 * Created with IntelliJ IDEA.
 * Description:另一个树的子树
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * User: starry
 * Date: 2021 -03 -16
 * Time: 14:44
 */
public class Work2 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(isSameTree(s,t)) return true;
        if(isSubtree(s.left,t)) return true;
        if(isSubtree(s.right,t)) return true;
        return false;
    }

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
