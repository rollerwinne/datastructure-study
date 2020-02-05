package cn.edu.bupt.p050_p076_sort;

import java.util.Arrays;

/**
 * 基数排序：针对正整数
 */
public class RadixSort {
    private static final int TEN = 10;//基数排序的桶个数

    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 基数排序
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {
        int max = arr[0], n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        int length = (max + "").length();//最大数的位数
        int[][] bucket = new int[TEN][n];
        int[] index = new int[TEN];//记录有效数据的下标
        int idx, num;//中间变量
        for (int i = 1, pow = 1; i <= length; i++, pow *= 10) {
            for (int a :arr) {
                num = a / pow % 10;
                bucket[num][index[num]++] = a;
            }
            idx = 0;//arr的下标
            for (int j = 0; j < TEN; j++) {//循环10个桶
                for (int k = 0; k < index[j]; k++) {
                    arr[idx++] = bucket[j][k];
                }
                index[j] = 0;//下标清零
            }
        }

    }

    /**
     * 韩老师的基数排序
     *
     * @param arr
     */
    public static void radixSortHan(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {//n用的好
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;

            }
        }
    }


    /**
     * 我尝试的基数排序：用bucket[10]代表10个桶
     *
     * @param arr
     * @param max 最大多少位
     */
    public static void radixSortTry(int[] arr, int max) {
        int n = arr.length;
        int[][] bucket = new int[TEN][n];
        int[] index = new int[TEN];//记录有效数据的下标
        int idx, num;//中间变量
        for (int i = 1; i <= max; i++) {
            for (int a : arr) {
                num = getNum(a, i);//第j位数字
                bucket[num][index[num]++] = a;
            }
            idx = 0;//arr的下标
            for (int j = 0; j < TEN; j++) {//循环10个桶
                for (int k = 0; k < index[j]; k++) {
                    arr[idx++] = bucket[j][k];
                }
                index[j] = 0;//下标清零
            }
        }
    }

    //取a的第k位数字，k=1为个位
    private static int getNum(int a, int k) {
        for (int i = 1; i < k; i++) {
            a /= 10;
        }
        return a % 10;
    }
}
