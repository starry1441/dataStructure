package sort;

import javax.swing.plaf.nimbus.State;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: starry
 * Date: 2021 -05 -03
 * Time: 14:53
 */
public class QuickSort2 {

    //相遇点
    public static int pivot(int[] array, int left, int right) {
        int piv = array[left];
        while (left < right) {
            while (left < right && array[right] >= piv) {
                right--;
            }
            array[left] = array[right];

            while (left < right && array[left] <= piv) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = piv;
        return left;
    }

    //快速排序---非递归
    public static void quickSort(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = array.length-1;
        stack.push(low);
        stack.push(high);
        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();
            int index = pivot(array,low,high);
            if(low+1 < index) {
                stack.push(low);
                stack.push(index-1);
            }
            if(high-1 > index) {
                stack.push(index+1);
                stack.push(high);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

}
