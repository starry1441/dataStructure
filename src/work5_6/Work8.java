package work5_6;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:旧键盘 (20)
 * https://www.nowcoder.com/questionTerminal/f88dafac00c8431fa363cd85a37c2d5e
 * User: starry
 * Date: 2021 -05 -06
 * Time: 20:28
 */
public class Work8 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String a = cin.nextLine().toUpperCase();
        String b = cin.nextLine().toUpperCase();
        Set<Character> set = new HashSet<>();
        Set<Character> con = new HashSet<>();
        for(char c : b.toCharArray()) {
            set.add(c);
        }
        for(char c : a.toCharArray()) {
            if(!set.contains(c) && !con.contains(c)) {
                con.add(c);
                System.out.print(c);
            }
        }
    }

}
