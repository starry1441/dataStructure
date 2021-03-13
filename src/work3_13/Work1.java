package work3_13;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 * User: starry
 * Date: 2021 -03 -13
 * Time: 13:56
 */
public class Work1 {

    public boolean isValid(String s) {
        Stack ret = new Stack();
        int i = 1;
        ret.push(s.charAt(0));
        while(i != s.length()) {
            if(ret.empty() || s.charAt(i) != change((char)ret.peek())) {
                ret.push(s.charAt(i));
            }else {
                ret.pop();
            }
            i++;
        }
        if(ret.empty()) return true;
        return false;
    }

    public char change(char a) {
        if(a == '(') return ')';
        if(a == '[') return ']';
        if(a == '{') return '}';
        return '?';
    }

}
