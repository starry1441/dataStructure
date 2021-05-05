package work5_5;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -05
 * Time: 18:43
 */
public class Test1 {
    //实例内部类
    public static void main(String[] args) {
        //InnerClass innerClass = new InnerClass();
        OuterClass out = new OuterClass();
        OuterClass.InnerClass innerClass2 = out.new InnerClass();
        innerClass2.test();
    }

}
