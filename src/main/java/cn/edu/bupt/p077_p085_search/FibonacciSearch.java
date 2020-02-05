package cn.edu.bupt.p077_p085_search;

import cn.edu.bupt.p050_p076_sort.SortUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * 斐波那契查找
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int length = 20;
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = i + 1;//random.nextInt(100);
        }
        SortUtils.quickSort(arr);
        int[] arr2 = {1, 8, 10, 1000, 1234};
        System.out.println(Arrays.toString(arr));
        System.out.println(fibonacciSearch(arr, 0, arr.length - 1, arr[4]));
        System.out.println(fibonacciSearch(arr, arr[7]));
        System.out.println(fibonacciSearchHan(arr, arr[13]));
        System.out.println(fibonacciSearchHan(arr2, 8));
    }

    private static final int maxSize = 20;
    private static final int[] fib = new int[maxSize];

    //生成斐波那契数列
    static {
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
    }

    /**
     * 我理解的斐波那契查找(递归法)
     * 不是严格的黄金分割比例，直接mid=floor(left+(right-left)*0.618)也可以
     *
     * @param arr
     * @param left
     * @param right
     * @param value
     * @return
     */
    public static int fibonacciSearch(int[] arr, int left, int right, int value) {
        if (left > right || value < arr[left] || value > arr[right])
            return -1;
        int length = right - left + 1;
        int k = 0;
        while (length > fib[k] - 1)
            k++;
        int mid = left + fib[k - 1] - 1;//中间值
        if (arr[mid] > value)
            return fibonacciSearch(arr, left, mid - 1, value);
        if (arr[mid] < value)
            return fibonacciSearch(arr, mid + 1, right, value);
        return mid;
    }

    /**
     * 我理解的斐波那契查找（迭代法）
     * 每次都通过循环确定k值，不如韩老师k-=1/k-=2的方法快
     * 且不是严格的黄金分割比例
     *
     * @param arr
     * @param value
     * @return
     */
    public static int fibonacciSearch(int[] arr, int value) {
        int left = 0, right = arr.length - 1;
        int k, length, mid;
        while (left <= right) {
            length = right - left + 1;
            k = 0;
            while (length > fib[k] - 1)
                k++;
            mid = left + fib[k - 1] - 1;
            if (arr[mid] == value)
                return mid;
            if (arr[mid] > value)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    /**
     * 韩老师的斐波那契查找
     * 原代码有问题:数组长度为1时会抛出异常(已标注修改)
     * 每次都遵循严格的黄金分割比例划分
     *
     * @param arr
     * @param key
     * @return
     */
    public static int fibonacciSearchHan(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        int k = 0, mid;
        while (arr.length > fib[k] - 1) {//这里原来为high是错的
            k++;
        }
        int[] temp = Arrays.copyOf(arr, fib[k] - 1);//这里原代码没有减一也不严格
        System.out.println(temp.length);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high) {
            mid = low + fib[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }

}
