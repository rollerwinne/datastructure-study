package cn.edu.bupt.p050_p076_sort;

import java.util.Arrays;

/**
 * 希尔排序(缩小增量排序):改进的插入排序
 */
public class ShellSort {
    public static void main(String[] args) {
        //Number[] arr = {3d, 1L, 4f, 2, 9d, -3, 0};
        int[] arr = {3, 1, 4, 2, 9, -3, 0};
        //System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序（移位）
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int insertIndex;
                for (insertIndex = i - gap; insertIndex >= 0; insertIndex -= gap) {
                    if (arr[insertIndex] < arr[i])
                        break;
                }
                //insertIndex+=gap;//加上这句，则后面须有所调整
                temp = arr[i];
                for (int j = i - gap; j > insertIndex; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[insertIndex + gap] = temp;
            }
        }
    }

    /**
     * 希尔排序(交换)
     *
     * @param arr
     */
    public static void shellSortSwap(int[] arr) {
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    /**
     * 我以为的希尔排序（一气呵成）：不太好在单纯是增量+简单插入的复合，太麻烦了
     *
     * @param arr
     */
    public static void shellSortWrong1(int[] arr) {
        int n = arr.length;
        int gap = n / 2;
        while (gap != 0) {//增量循环
            for (int start = 0; start < gap; start++) {//每个gap,要做gap次插入排序，每次的起始位置start为1到gap-1
                for (int i = start + gap; i < n; i += gap) {//每次插入排序，以gap为增量,i为待插入的下标
                    int insertIndex;
                    for (insertIndex = start; insertIndex < i; insertIndex += gap) {//确定插入位置
                        if (arr[insertIndex] > arr[i]) {
                            break;
                        }
                    }
                    int temp = arr[i];
                    for (int j = i; j > insertIndex; j -= gap) {//移动数组元素
                        arr[j] = arr[j - gap];
                    }
                    arr[insertIndex] = temp;
                }
            }
            gap /= 2;
        }
    }

    /**
     * 我以为的希尔排序（封装函数）：不太好在单纯是增量+简单插入的复合，太麻烦了
     *
     * @param arr
     */
    public static void shellSortWrong2(int[] arr) {
        int n = arr.length;
        int gap = n / 2;
        while (gap != 0) {
            for (int start = 0; start < gap; start++) {
                gapSelectSort(arr, start, gap);
            }
            gap /= 2;
        }
    }

    /**
     * 增量的简单插入排序
     *
     * @param arr
     * @param start 起始坐标
     * @param gap   增量值
     */
    private static void gapSelectSort(int[] arr, int start, int gap) {
        int n = arr.length;
        for (int i = start + gap; i < n; i += gap) {
            int insertIndex;
            for (insertIndex = start; insertIndex < i; insertIndex += gap) {
                if (arr[insertIndex] > arr[i])
                    break;
            }
            int temp = arr[i];
            for (int j = i; j > insertIndex; j -= gap) {
                arr[j] = arr[j - gap];
            }
            arr[insertIndex] = temp;
        }
    }
}
