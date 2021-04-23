package work4_23;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -04 -23
 * Time: 10:53
 */
public class TestDemo {


    public static void preOrder(BinarySearchTree.BSNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(BinarySearchTree.BSNode root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(4);
        tree.insert(3);
        tree.insert(15);
        tree.insert(1);
        tree.insert(11);

        preOrder(tree.root);
        System.out.println();
        inOrder(tree.root);
        System.out.println();

        tree.remove(15);

        preOrder(tree.root);
        System.out.println();
        inOrder(tree.root);
        System.out.println();


//        try {
//            BinarySearchTree.BSNode ret = tree.search(15);
//            System.out.println(ret.val);
//        }catch (NullPointerException e) {
//            System.out.println("没有找到当前节点。。。");
//        }
    }

}
