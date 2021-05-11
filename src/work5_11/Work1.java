package work5_11;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -11
 * Time: 9:15
 */

//无返回值无参数
@FunctionalInterface
interface NoParameterNoReturn {
    //注意：只能有一个方法
    void test();
//    default void test2() {
//        System.out.println("JDK1.8新特性，default默认方法可以有具体的实现");
//    }
}

//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}

//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}

//有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}

//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}

//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}

public class Work1 {

    public static void main(String[] args) {
        //无返回值无参数
        NoParameterNoReturn noParameterNoReturn = () -> {
            System.out.println("lala");
        };
        noParameterNoReturn.test();//lala

        //无返回值一个参数
        OneParameterNoReturn oneParameterNoReturn = (int a) -> {
            System.out.println(a);
        };
        oneParameterNoReturn.test(10);//10

        //无返回值多个参数
        MoreParameterNoReturn moreParameterNoReturn = (int a,int b) -> {
            System.out.println(a+b);
        };
        moreParameterNoReturn.test(10,20);//30

        //有返回值无参数
        NoParameterReturn noParameterReturn = () -> {
            return 10;
        };
        System.out.println(noParameterReturn.test());//10
        //可简写
        NoParameterReturn noParameterReturn2 = () -> 10;
        System.out.println(noParameterReturn2.test());//10

        //有返回值一个参数
        OneParameterReturn oneParameterReturn = (int a) -> {
            return a;
        };
        System.out.println(oneParameterReturn.test(4));//4
        //可简写
        OneParameterReturn oneParameterReturn2 = a -> a;
        System.out.println(oneParameterReturn2.test(10));

        //有返回值多参数
        MoreParameterReturn moreParameterReturn = (int a,int b) -> {
            return a+b;
        };
        System.out.println(moreParameterReturn.test(2,3));//5
        MoreParameterReturn moreParameterReturn2 = (a,b) -> a+b;
        System.out.println(moreParameterReturn2.test(2,3));//5
    }

}
