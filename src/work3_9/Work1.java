package work3_9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 删除第一个字符串当中出现的第二个字符串中的字符
 * str1 = "welcome to my home"
 * str2 = "come"
 * 输出："wl t y h"
 * User: starry
 * Date: 2021 -03 -09
 * Time: 16:08
 */
public class Work1 {

    //用集合arraylist
    public static List<Character> delete(String a, String b) {
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < a.length(); i++) {
            if(b.contains(a.charAt(i)+"")) {
                continue;
            }
            list.add(a.charAt(i));
        }
        return list;
    }

    //用stringbuilder
    public static String delete1(String a, String b) {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < a.length(); i++) {
            if(b.contains(a.charAt(i)+"")) {
                continue;
            }
            s.append(a.charAt(i));
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String a = "welcome to my home";
        String b = "come";
        System.out.println(delete(a,b));
        String c = delete1(a,b);
        System.out.println(c);
    }
}
