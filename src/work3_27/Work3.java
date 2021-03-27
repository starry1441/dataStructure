package work3_27;

import work3_16.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:106. 从中序与后序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * User: starry
 * Date: 2021 -03 -27
 * Time: 18:18
 */

public class Work3 {

    public int postIndex = 0;
    public TreeNode buildTreeChild(int[] inorder, int[] postorder, int start, int end) {
        if(start > end) return null;
        TreeNode root = new TreeNode(postorder[postIndex]);
        int index = findIndex(inorder,postorder[postIndex],start,end);
        postIndex--;
        root.right = buildTreeChild(inorder,postorder,index+1,end);
        root.left = buildTreeChild(inorder,postorder,start,index-1);

        return root;
    }

    public int findIndex(int[] inorder,int key,int start,int end) {
        for(int i = start; i <= end; i++) {
            if(inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null) return null;
        if(inorder.length == 0 || postorder.length == 0) return null;
        postIndex = postorder.length-1;
        return buildTreeChild(inorder,postorder,0,inorder.length-1);
    }

    public static void main(String[] args) {
        Work3 a = new Work3();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = a.buildTree(inorder,postorder);
    }

}
