package work3_27;

import work3_16.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * Description:错误示范！！！！！！
 * User: starry
 * Date: 2021 -03 -27
 * Time: 17:21
 */
public class Work2 {

    //postorder不能做局部变量，因为递归会回溯，回溯到上一节点后，postorder就变了
    public TreeNode buildTreeChild(int[] inorder, int[] postorder, int postIndex, int start, int end) {
        if(start > end) return null;
        TreeNode root = new TreeNode(postorder[postIndex]);
        int index = findIndex(inorder,postorder[postIndex],start,end);
        postIndex--;
        root.right = buildTreeChild(inorder,postorder,postIndex,index+1,end);
        root.left = buildTreeChild(inorder,postorder,postIndex,start,index-1);

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
        int postIndex = postorder.length-1;
        return buildTreeChild(inorder,postorder,postIndex,0,inorder.length-1);
    }

    public TreeNode createTree() {
        TreeNode cur3 = new TreeNode(3);
        TreeNode cur9 = new TreeNode(9);
        TreeNode cur20 = new TreeNode(20);
        TreeNode cur15 = new TreeNode(15);
        TreeNode cur7 = new TreeNode(7);
        cur3.left = cur9;
        cur3.right = cur20;
        cur20.left = cur15;
        cur20.right = cur7;
        return cur3;
    }

    public static void main(String[] args) {
        Work2 a = new Work2();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = a.buildTree(inorder,postorder);
    }

}
