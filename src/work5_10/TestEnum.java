package work5_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -10
 * Time: 20:41
 */

public enum TestEnum {
    RED("red",1),GREEN("green",2),BLACK("black",3);

    public String color;
    public int ordinal;

    /**
     *  1、当枚举对象有参数后，需要提供相应的构造函数
     *  2、枚举的构造函数默认是私有的
     * @param color
     * @param ordinal
     */
    private TestEnum(String color,int ordinal) {
        this.color = color;
        this.ordinal = ordinal;
    }

    public static void reflectPrivateConstructor() {
        try {
            Class<?> c1 = Class.forName("work5_10.TestEnum");
            //因为枚举类是默认继承java.lang.Enum的，Enum是抽象类，子类要帮助父类进行构造，我们这个构造函数默认帮我们构造父类了，但是这里要再传入父类的两个参数
            Constructor<?> constructor = c1.getDeclaredConstructor(String.class,int.class,String.class,int.class);
            constructor.setAccessible(true);
            TestEnum yello = (TestEnum) constructor.newInstance("黄色",4,"父类的参数",10);
            System.out.println(yello);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        reflectPrivateConstructor();
    }

    public static void main2(String[] args) {
        //将当前的枚举对象，封装为数组
        TestEnum[] testEnums = TestEnum.values();
        for (TestEnum testEnum : testEnums) {
            System.out.print(testEnum + " ");//RED GREEN BLACK
        }
        System.out.println();
        //打印枚举对象数组的下标
        for (int i = 0; i < testEnums.length; i++) {
            System.out.print(testEnums[i].ordinal() + " ");//0 1 2
        }
        System.out.println();
        //根据字符串解析出来一个枚举对象
        System.out.println(TestEnum.valueOf("GREEN"));//GREEN

        System.out.println(RED.compareTo(BLACK));//-2
    }

    public static void main1(String[] args) {
        TestEnum testEnum = TestEnum.BLACK;
        switch (testEnum) {
            case RED:
                System.out.println("red");
                break;
            case GREEN:
                System.out.println("green");
                break;
            case BLACK:
                System.out.println("black");
                break;
            default:
                break;
        }
    }
}
