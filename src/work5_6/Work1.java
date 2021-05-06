package work5_6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -06
 * Time: 15:39
 */
public class Work1 {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        //add
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);//[1, 2, 3]

        //clear
        set.clear();
        System.out.println(set);//[]
        set.add(1);
        set.add(2);
        set.add(3);

        //contains
        boolean a = set.contains(2);
        boolean b = set.contains(4);
        System.out.println(a);//true
        System.out.println(b);//false

        //iterator
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");//1 2 3
        }
        System.out.println();

        //remove
        System.out.println(set.remove(1));//true
        System.out.println(set.remove(4));//false
        set.add(1);

        //size
        System.out.println(set.size());//3

        //isEmpty
        System.out.println(set.isEmpty());//false

        //toArray
        Object[] arr = set.toArray();
//        int[] arr2 = set.toArray(new int[set.size()]);
//        Integer[] arr1 = set.toArray(new Integer[set.size()]);
        System.out.println(Arrays.toString(arr));//[1, 2, 3]

        //containsAll
        Set<Integer> set2 = new HashSet<>();
        set.add(3);
        set2.add(4);
        System.out.println(set.containsAll(set2));//false

        //addAll
        set.addAll(set2);
        System.out.println(set);//[1, 2, 3, 4]

        for (int i : set) {
            System.out.print(i);//1234
        }
    }

}
