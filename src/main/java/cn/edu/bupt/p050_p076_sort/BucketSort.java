package cn.edu.bupt.p050_p076_sort;

import java.util.Arrays;

/**
 * 桶排序
 */
public class BucketSort {
    public static void main(String[] args) {
        //int[] arr = {3, 1, 4, 2, 9, -3, 0, 3, 2, 1, 5, 7};
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(Arrays.toString(arr));
        bucketSortWrong(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 桶排序：每个桶内部采用快排(也可改为其他排序)
     *
     * @param arr
     * @param bucketNum 桶的个数
     */
    public static void bucketSort(int[] arr, int bucketNum) {
        int n = arr.length;
        int max = arr[0], min = arr[0];
        for (int value : arr) {
            if (value > max)
                max = value;
            if (value < min)
                min = value;
        }
        int range = (max - min + 1) / bucketNum + 1; //最后的+1是为了防止数组越界，或者用向上取整也可
        int[][] bucket = new int[bucketNum][n];
        int[] index = new int[bucketNum];
        for (int val : arr) {
            int bucketIndex = (val - min) / range;
            bucket[bucketIndex][index[bucketIndex]++] = val;
        }
        for (int i = 0; i < bucketNum; i++) {
            QuickSort.quickSort(bucket[i], 0, index[i] - 1);//桶内部采用快排
        }
        for (int i = 0, idx = 0; i < bucketNum; i++) {
            for (int j = 0; j < index[i]; j++) {
                arr[idx++] = bucket[i][j];
            }
        }
    }

    /**
     * 桶排序(每个桶放4个)
     *
     * @param arr
     */
    public static void bucketSortWrong(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int len = arr.length;
        int bucketCount = len / 4;
        int min = 0, max = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }
        int range = (max - min + 1) / bucketCount + 1;//这里要加1
        int[][] buckets = new int[bucketCount][];
        for (int i = 0; i < len; i++) {
            int val = arr[i];
            int bucketIndex = (int) Math.floor((val - min) / range);
            buckets[bucketIndex] = appendItem(buckets[bucketIndex], val);
        }
        int k = 0;
        for (int[] b : buckets) {
            if (b != null) {
                for (int i = 0; i < b.length; i++) {
                    arr[k++] = b[i];
                }
            }
        }
    }

    private static int[] appendItem(int[] bucketArr, int val) {
        if (bucketArr == null || bucketArr.length == 0) {
            return new int[]{val};
        }
        int[] arr = Arrays.copyOf(bucketArr, bucketArr.length + 1);
        int i;
        for (i = arr.length - 2; i >= 0 && arr[i] > val; i--) {
            arr[i + 1] = arr[i];
        }
        arr[i + 1] = val;
        return arr;
    }
}
