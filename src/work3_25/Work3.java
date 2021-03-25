package work3_25;

import work3_16.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:二叉搜索树与双向链表
 * https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tqId=11179&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
 * User: starry
 * Date: 2021 -03 -25
 * Time: 12:03
 */
public class Work3 {

    public TreeNode prev = null;
    public void ConvertChild(TreeNode pCur) {
        if(pCur == null) return;
        ConvertChild(pCur.left);
        pCur.left = prev;
        if(prev != null) {
            prev.right = pCur;
        }
        prev = pCur;
        ConvertChild(pCur.right);
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        ConvertChild(pRootOfTree);
        TreeNode head = pRootOfTree;
        while(head.left != null) {
            head = head.left;
        }
        return head;
    }

}
