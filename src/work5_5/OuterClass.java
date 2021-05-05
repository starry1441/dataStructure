package work5_5;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -05
 * Time: 18:41
 */

public class OuterClass {
    public int data1 = 1;
    public static int data2 = 2;
    class InnerClass {
        public int data3 = 3;
        public int data1 = 11;
        public static final int data4 = 4;
        public InnerClass() {
        }
        public void test() {
            System.out.println("InnerClass::test()");
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(this.data1);
            System.out.println(OuterClass.this.data1);
        }
    }
}
