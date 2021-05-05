package work5_4;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -04
 * Time: 18:35
 */

/**
 * 1. class MyStack<T> 此时<T>代表是一个占位符，表示当前类是一个泛型类
 * 2. this.elem = new T[10]; 不能实例化泛型类型的数组对象
 * 3. Mystack<Integer> myStack = new MyStack<>();
 *    MyStack<Integer> 这里指定当前类可以存放的数据类型
 *    new MyStack<>() 与前面匹配
 * 4. 泛型的意义：
 *      a：可以自动进行类型的检查
 *      b：可以自动进行类型的转换
 * 5. MyStack<int> myStack = new MyStack<>();
 *    简单类型 不能作为泛型类型的参数 包装类型->引用类型
 * 6. 泛型到底是怎么编译的？ 擦除机制
 *    擦除为Object的意义 就是可以放任意类型的数据
 *    运行java程序的时候，是没有泛型的概念的
 * 7. MyStack<Integer> stack : 泛型类型的参数，不参与类型的组成
 * 8. 泛型的上界：
 *    class Algorithm<T extends Comparable<T> > {}
 *    T：T类型一定要实现Comparable接口
 *    class Algorithm<E extends Animal> {}
 *    E：可以是Animal的子类，或者是Animal自己类本身
 * 9. 泛型没有下界
 * 10.泛型方法：
 *    public static<T> T findMaxVal(T[] array) {}
 *    public static<T extends Comparable<T>> T findMaxVal(T[] array) {}
 * 11.通配符：通配符实际上也是一种泛型。一般在源码中居多一点
 *    泛型一般用于读取和写入，而通配符一般用于读取
 *    public static<T> void print(ArrayList<T> list) {}
 *    public static void print(ArrayList<?> list) {}
 *    通配符上界：<? extends E> 表示传入的参数 ? 是上界 E 的子类或者 E 自己本身
 *    通配符下界：<? super E> 表示传入的参数 ? 是下界 E 的父类或者 E自己本身
 * 12.ArrayList<Integer> list  ArrayList<Number> list
 *    他们不会构成父子类关系，因为类型擦除机制 以及 不参与类型的组成
 * @param <T>
 */

class MyStack<T> {
    public T[] elem;
    public int top;

    public MyStack() {
        this.elem = (T[])new Object[10];
    }

    public void push(T val) {
        this.elem[top] = val;
        top++;
    }

    public T getTop() {
        return this.elem[top-1];
    }
}

public class Work1 {

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
    }

}
