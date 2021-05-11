package work5_11;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -11
 * Time: 14:06
 */

class Test {
    public void func() {
        System.out.println("lala");
    }
}

public class Work2 {

    public static void main(String[] args) {
        int a = 100;
        new Test() {
            @Override
            public void func() {
                System.out.println("匿名内部类function");
                System.out.println("捕获到的变量" + a + "这个变量是不能修改过的！");
            }
        }.func();
    }

}

