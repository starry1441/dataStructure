package Work3_15;

/**
 * Created with IntelliJ IDEA.
 * Description:二叉树
 * User: starry
 * Date: 2021 -03 -15
 * Time: 19:28
 */

class BTNode {
    public char val;
    public BTNode left; //左子树的引用
    public BTNode right;//右子树的引用

    public BTNode(char val) {
        this.val = val;
    }
}

public class BinaryTree {

    //我们先以穷举的方式创建二叉树
    public BTNode createTree() {
        BTNode A = new BTNode('A');
        BTNode B = new BTNode('B');
        BTNode C = new BTNode('C');
        BTNode D = new BTNode('D');
        BTNode E = new BTNode('E');
        BTNode F = new BTNode('F');
        BTNode G = new BTNode('G');
        BTNode H = new BTNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }

    // 前序遍历
    void preOrderTraversal(BTNode root){
        if(root == null) return;
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // 中序遍历
    void inOrderTraversal(BTNode root){
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val);
        inOrderTraversal(root.right);
    }

    // 后序遍历
    void postOrderTraversal(BTNode root){
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val);
    }

    // 遍历思路-求结点个数,只要不为空size++
    static int size = 0;
    void getSize1(BTNode root) {
        if(root == null) return;
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }

    // 子问题思路-求结点个数，左树+右树+1
    int getSize2(BTNode root) {
        if(root == null) return 0;
        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(BTNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    // 子问题思路-求叶子结点个数
    int getLeafSize2(BTNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(BTNode root, int k) {
        if(root == null) return 0;
        if(k == 1) {
            return 1;
        }
        return getKLevelSize(root.left,k-1) + getKLevelSize(root.right,k-1);
    }

    // 获取二叉树的高度
    int getHeight(BTNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return 1;
        }
        int lefthigh = getHeight(root.left);
        int righthigh = getHeight(root.right);
        int max = Math.max(lefthigh,righthigh);
        return max+1;
    }

    // 获取二叉树的高度2
    int getHeight2(BTNode root) {
        if(root == null) return 0;
        int lefthight = getHeight(root.left);
        int righthight = getHeight(root.right);
        return lefthight > righthight ? lefthight+1 : righthight+1;
    }

    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    BTNode find(BTNode root, char val) {
        if (root == null) return null;
        if(root.val == val) return root;
        BTNode a = find(root.left, val);
        if(a != null) {
            return a;
        }
        BTNode b = find(root.right, val);
        if(b != null) {
            return b;
        }
        return null;
    }

}
