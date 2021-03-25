package work3_25;


/**
 * Created with IntelliJ IDEA.
 * Description:二叉树的构建及遍历
 * https://www.nowcoder.com/practice/4b91205483694f449f94c179883c1fef?tpId=60&tqId=29483&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Ftsing-kaoyan%2Fquestion-ranking&tab=answerKey
 * User: starry
 * Date: 2021 -03 -25
 * Time: 9:43
 */

class TreeCharNode {
    public char val;
    public TreeCharNode left;
    public TreeCharNode right;

    public TreeCharNode(char ch) {
        this.val = ch;
    }
}


public class Work1 {

    static int i = 0;
    public static TreeCharNode createTree(String str) {
        if(str == null || str.length() <= 0) {
            return null;
        }
        TreeCharNode root = null;
        if(str.charAt(i) != '#') {
            root = new TreeCharNode(str.charAt(i));
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        }else {
            i++;
        }
        return root;
    }
    public static void middle(TreeCharNode root) {
        if(root == null) return;
        middle(root.left);
        System.out.print(root.val+" ");
        middle(root.right);
    }

    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        String str = cin.nextLine();
        String str = "ABC##DE#G##F###";
        TreeCharNode root = createTree(str);
        middle(root);
    }

}
