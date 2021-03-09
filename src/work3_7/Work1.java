package work3_7;

import org.omg.CORBA.Object;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -03 -07
 * Time: 15:06
 */

//<T>代表占位符，表示当前这个类是一个泛型类
class MyArrayList <T> {
    public T[] elem;
    public int usedsize;

    public MyArrayList() {
        this.elem = (T[])new Object[10];
    }
    public void add(T data) {
        this.elem[this.usedsize] = data;
        this.usedsize++;
    }
    public T get(int pos) {
        return this.elem[pos];
    }
}

public class Work1 {
    public static void main(String[] args) {
        MyArrayList<String> arr1 = new MyArrayList<>();  //这时顺序表中只能放String类型数据
//        arr1.add(1);    //错误，类型不匹配
//        arr1.add(16.5); //错误，类型不匹配
        arr1.add("hello");  //正确，字符串型数据

        MyArrayList<Integer> arr2 = new MyArrayList<>();  //整型

        MyArrayList<Float> arr3 = new MyArrayList<>();    //浮点型
//        MyArrayList arr = new MyArrayList();
//        arr.add(1);
//        arr.add(16.5);
//        arr.add("hello");
//        String str = (String)arr.get(2);
//        System.out.println(str);
    }
}
