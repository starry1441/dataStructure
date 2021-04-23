package work4_23;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -04 -23
 * Time: 10:24
 */
public class BinarySearchTree {

    static class BSNode {
        public int val;
        public BSNode left;
        public BSNode right;
        public BSNode(int val) {
            this.val = val;
        }
    }

    public BSNode root = null;

    public BSNode search(int val) {
        if(root == null) return null;

        BSNode cur = root;
        while(cur != null) {
            if(cur.val > val) {
                cur = cur.left;
            }else if(cur.val < val) {
                cur = cur.right;
            }else {
                return cur;
            }
        }
        return null;
    }

    public boolean insert(int val) {
        BSNode bsNode = new BSNode(val);
        if(root == null) {
            root = bsNode;
            return true;
        }
        BSNode cur = root;
        BSNode parent = new BSNode(val);
        while(cur != null) {
            if(cur.val == val) {
                return false;
            }
            parent = cur;
            if(cur.val > val) {
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        if(parent.val > val) {
            parent.left = bsNode;
        }else{
            parent.right = bsNode;
        }
        return true;
    }

    public void remove(int val) {
        if(root == null) {
            return;
        }
        BSNode cur = root;
        BSNode parent = null;
        while(cur != null) {
            if(cur.val == val) {
                removeNode(parent,cur,val);
                return;
            }else if(cur.val < val) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
    }

    public void removeNode(BSNode parent, BSNode cur, int val) {
         if(cur.left == null) {
             if(cur == root) {
                 root = root.right;
             }else {
                 if(cur == parent.left) {
                     parent.left = cur.right;
                 }
                 if(cur == parent.right) {
                     parent.right = cur.right;
                 }
             }
         }else if(cur.right == null) {
             if(cur == root) {
                 root = root.left;
             }else {
                 if(cur == parent.left) {
                     parent.left = cur.left;
                 }
                 if(cur == parent.right) {
                     parent.right = cur.left;
                 }
             }
         }else {
             BSNode targetParent = cur;
             BSNode target = cur.right;
             while (target.left != null) {
                 targetParent = target;
                 target = target.left;
             }
             //代码走到这里，target指向的 右边的最小值
             cur.val = target.val;

             if(target == targetParent.left) {
                 targetParent.left = target.right;
             }else {
                 targetParent.right = target.right;
             }
         }
    }

}
