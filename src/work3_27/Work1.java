package work3_27;

import work3_16.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * User: starry
 * Date: 2021 -03 -27
 * Time: 17:21
 */
public class Work1 {

    public int preindex = 0;
    public TreeNode buildTreeChild(int[] preorder, int[] inorder, int start, int end) {
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[preindex]);
        int index = findIndex(preorder[preindex],inorder,start,end);
        preindex++;
        root.left = buildTreeChild(preorder,inorder,start,index-1);
        root.right = buildTreeChild(preorder,inorder,index+1,end);
        return root;
    }

    public int findIndex(int key,int[] inorder,int start,int end) {
        for(int i = start; i <= end; i++) {
            if(key == inorder[i]) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;
        if(preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = buildTreeChild(preorder,inorder,0,inorder.length-1);
        return root;
    }

    public static void main(String[] args) {
        Work1 a = new Work1();
        int[] inorder = {9,3,15,20,7};
        int[] preorder = {3,9,20,15,7};
        TreeNode root = a.buildTree(preorder,inorder);
    }

}
