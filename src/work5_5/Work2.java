package work5_5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -05
 * Time: 21:49
 */
public class Work2 {

    public static void main(String[] args) {

        //两种创建方式
        HashMap<String,Integer> hashMap = new HashMap<>();
        Map<String,Integer> map = new HashMap<>();

        //put
        map.put("xing",1);
        map.put("fei",2);
        map.put("fan",3);
        System.out.println(map);//{xing=1, fan=3, fei=2}

        //get
        int a = map.get("xing");
        System.out.println(a);  //1

        //get
        int b = map.getOrDefault("xing",88);
        int c = map.getOrDefault("lala",88);
        System.out.println(b);//1
        System.out.println(c);//88

        //remove
        map.remove("fan");
        System.out.println(map);//{xing=1, fei=2}
        map.put("fan",3);

        //keySet
        Set<String> set = map.keySet();
        System.out.println(set);//[xing, fan, fei]

        //values
        Collection<Integer> val = map.values();
        System.out.println(val);//[1, 3, 2]

        //entrySet
        Set<Map.Entry<String,Integer>> set2 = map.entrySet();
        for(Map.Entry<String,Integer> entry : set2) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + "  ");//xing=1  fan=3  fei=2
        }
        System.out.println();

        //containsKey
        boolean d = map.containsKey("xing");
        boolean e = map.containsKey("lala");
        System.out.println(d);//true
        System.out.println(e);//false

        // containsValue
        boolean f = map.containsValue(2);
        boolean g = map.containsValue(5);
        System.out.println(f);//true
        System.out.println(g);//false
    }

}
