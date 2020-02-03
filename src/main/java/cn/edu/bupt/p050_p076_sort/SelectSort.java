package cn.edu.bupt.p050_p076_sort;

import java.util.Arrays;

/**
 * 选择排序：每次循环通过一次交换，确定第i位
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 9, -3, 0};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * 带泛型的选择排序
     *
     * @param arr
     */
    public static <T extends Number> void selectSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min].longValue() > arr[j].longValue()) {
                    min = j;
                }
            }
            if (min != i) {
                T temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
