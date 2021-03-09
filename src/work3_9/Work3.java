package work3_9;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -03 -09
 * Time: 20:00
 */
public class Work3 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());   //3
        System.out.println(stack.pop());    //3
        System.out.println(stack.peek());   //2
        System.out.println(stack.empty());  //false
        System.out.println(stack.search(2));    //1
        System.out.println(stack.search(1));    //2
    }

}
