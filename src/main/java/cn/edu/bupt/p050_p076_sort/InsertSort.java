package cn.edu.bupt.p050_p076_sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 9, -3, 0};
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序:for-for循环，从小到大比较
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < arr.length; i++) {
            int insertIndex;
            for (insertIndex = 0; insertIndex < i; insertIndex++) {
                if (arr[insertIndex] > arr[i])
                    break;
            }
            int temp = arr[i];
            for (int j = i; j > insertIndex; j--) {
                arr[j] = arr[j - 1];
            }
            arr[insertIndex] = temp;
        }
    }

    /**
     * 插入排序(韩老师):for-while循环，从大到小比较
     *
     * @param arr
     */
    public static void insertSort2(int[] arr) {
        int insertVal;
        int insertIndex;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    /**
     * 带泛型的插入排序
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Number> void insertSort(T[] arr) {
        int n = arr.length;
        for (int i = 1; i < arr.length; i++) {
            int insertIndex;
            for (insertIndex = 0; insertIndex < i; insertIndex++) {
                if (arr[insertIndex].longValue() > arr[i].longValue())
                    break;
            }
            T temp = arr[i];
            for (int j = i; j > insertIndex; j--) {
                arr[j] = arr[j - 1];
            }
            arr[insertIndex] = temp;
        }
    }
}
