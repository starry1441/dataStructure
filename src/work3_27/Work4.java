package work3_27;

import work3_16.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:根据二叉树创建字符串
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 * User: starry
 * Date: 2021 -03 -27
 * Time: 20:47
 */
public class Work4 {

    public void tree2strChild(TreeNode t, StringBuilder sb) {
        if(t == null) return;
        sb.append(t.val);
        if(t.left == null) {
            if(t.right == null) {
                return;
            }else{
                sb.append("()");
            }
        }else {
            sb.append("(");
            tree2strChild(t.left,sb);
            sb.append(")");
        }

        if(t.right == null) {
            return;
        }else{
            sb.append("(");
            tree2strChild(t.right,sb);
            sb.append(")");
        }
    }

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        tree2strChild(t,sb);
        return sb.toString();
    }

}
