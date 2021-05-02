package sort;

/**
 * Created with IntelliJ IDEA.
 * Description:折半插入排序
 * User: starry
 * Date: 2021 -05 -02
 * Time: 22:02
 */
public class BsInsertSort {

    public static void bsInsertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int v = array[i];
            int left = 0;
            int right = i;
            // [left, right)
            // 需要考虑稳定性
            while (left < right) {
                int m = (left + right) / 2;
                if (v >= array[m]) {
                    left = m + 1;
                } else {
                    right = m;
                }
            }
            // 搬移
            for (int j = i; j > left; j--) {
                array[j] = array[j - 1];
            }
            array[left] = v;
        }
    }

}
