package work3_7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -03 -07
 * Time: 17:32
 */
public class Work3 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        iterator.remove();
        System.out.println(list);   //[1, 2, 3, 4]
//        List<Integer> a = list.subList(1,3);
//        System.out.println(a);  //[2, 3]
//        a.set(0,99);
//        System.out.println(a);  //[99, 3]
//        System.out.println(list);   //[1, 99, 3, 4, 5]
    }

}
