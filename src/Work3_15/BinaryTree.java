package Work3_15;

import work3_16.TreeNode;

import java.util.*;

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

    //层序遍历
    void levelOrderTraversal(BTNode root) {
        if(root == null) return;
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);
        BTNode cur = root;
        while(!queue.isEmpty()) {
            cur = queue.poll();
            System.out.println(cur.val);
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }

    }

    public List<List<Character>> levelOrder(BTNode root) {
        if(root == null) return null;
        List<List<Character>> out = new ArrayList<>();
        Queue<BTNode> queue1 = new LinkedList<>();
        Queue<BTNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Character> in = new ArrayList<>();
            boolean join1 = false;
            while (!queue1.isEmpty()) {
                join1 = true;
                BTNode cur = queue1.poll();
                in.add(cur.val);
                if(cur.left != null) {
                    queue2.offer(cur.left);
                }
                if(cur.right != null) {
                    queue2.offer(cur.right);
                }
            }
            if (join1) {
                out.add(in);
                continue;
            }
            while (!queue2.isEmpty()) {
                BTNode cur = queue2.poll();
                in.add(cur.val);
                if(cur.left != null) {
                    queue1.offer(cur.left);
                }
                if(cur.right != null) {
                    queue1.offer(cur.right);
                }
            }
            out.add(in);
        }
        return out;
    }

    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(BTNode root) {
        if (root == null) return false;
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            BTNode cur = queue.poll();
            if(cur == null) {
                break;
            }else {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        while(!queue.isEmpty()) {
            BTNode cur = queue.poll();
            if(cur != null) return false;
        }
        return true;
    }

    // 前序遍历---非递归
    void preOrderTraversalNor(BTNode root) {
        if(root == null) return;
        Stack<BTNode> stack = new Stack<>();
        BTNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.println(cur.val + " ");
                cur = cur.left;
            }
            BTNode top = stack.pop();
            cur = top.right;
        }
        System.out.println();
    }

    // 中序遍历---非递归
    void inOrderTraversalNor(BTNode root) {
        if(root == null) return;
        Stack<BTNode> stack = new Stack<>();
        BTNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            BTNode top = stack.pop();
            System.out.println(top.val + " ");
            cur = top.right;
        }
        System.out.println();
    }

    // 后序遍历---非递归
    void postOrderTraversalNor(BTNode root) {
        if(root == null) return;
        Stack<BTNode> stack = new Stack<>();
        BTNode cur = root;
        BTNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            BTNode top = stack.peek();
            if(top.right == null || top.right == prev) {
                stack.pop();
                System.out.println(top.val + " ");
                prev = top;
            }else {
                cur = top.right;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BTNode root = binaryTree.createTree();
        System.out.println(binaryTree.isCompleteTree(root));
    }

}
