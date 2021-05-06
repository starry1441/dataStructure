package work5_6;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:138. 复制带随机指针的链表
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * User: starry
 * Date: 2021 -05 -06
 * Time: 20:25
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Work6 {

    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null) {
            Node tmp = new Node(cur.val);
            map.put(cur,tmp);
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

}
