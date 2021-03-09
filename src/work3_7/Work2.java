package work3_7;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -03 -07
 * Time: 16:28
 */
public class Work2 {

    public static void main(String[] args) {
        Integer i = 10;
        int a1 = i;  //自动拆箱
        System.out.println(a1);
        int a2 = i.intValue();  //显示拆箱
        System.out.println(a2);
        double d = i.doubleValue();
        System.out.println(d);
    }

    public static void main1(String[] args) {
        int a = 10;
        Integer integer1 = new Integer(a);  //显示的装包
        System.out.println(integer1);
        Integer integer2 = Integer.valueOf(a);  //显示装包
        System.out.println(integer2);
        Integer integer3 = a;   //自动装包，其实也调用了Integer.valueOf()
    }

}
