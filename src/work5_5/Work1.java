package work5_5;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -05
 * Time: 8:23
 */

class Algorithm3 <T extends Comparable<T>> {
    public T findMaxVal(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}

/**
 * 泛型方法
 */
class Algorithm4 {
    public static<T extends Comparable<T>> T findMaxVal(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}


public class Work1 {

    public static void main(String[] args) {
        Algorithm<Integer> algorithm = new Algorithm<>();

    }

}
