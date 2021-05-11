package work5_11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -11
 * Time: 14:16
 */
public class Work3 {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "world");
        map.put(3, "hello");
        map.put(4, "lambda");
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer k, String v) {
                System.out.println(k + " " + v);
            }
        });

        //简化
        map.forEach((k,v) -> System.out.println(k+" "+v));
    }

    public static void main3(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("world");
        list.add("hello");
        list.add("lambda");
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        //简写
        list.sort((o1,o2) -> o1.compareTo(o2));
        list.forEach(s -> System.out.println(s));
    }

    public static void main2(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("world");
        list.add("hello");
        list.add("lambda");
        list.forEach(new Consumer<String>(){
            @Override
            public void accept(String str){
                //简单遍历集合中的元素。
                System.out.print(str+" ");
            }
        });

        //lambda写法
        list.forEach(s -> {
            System.out.println(s);
        });
    }

}
