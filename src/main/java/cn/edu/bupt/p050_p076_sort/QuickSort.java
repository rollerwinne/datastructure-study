package cn.edu.bupt.p050_p076_sort;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {
    public static void main(String[] args) {
        // int[] arr = {3, 1, 4, 2, 9, 2, 0};
        int[] arr = {-1, -2, -3, 2, 9, 1, 3, 4};
        System.out.println(Arrays.toString(arr));
        quickSortHan(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 递归法快排(常见写法，更简洁)：以第一个元素作为基准
     * 注意：先找右面再找左面；寻找条件不含相等
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end, base = arr[start];
        while (i < j) {
            while (arr[j] >= base && i < j) {
                j--;
            }
            while (arr[i] <= base && i < j) {
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[start] = arr[i];
        arr[i] = base;
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }

    /**
     * 韩老师的快速排序（稍加修改）:以中间为基准
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSortHan(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot)
                l++;
            while (arr[r] > pivot)
                r--;
            if (l >= r)
                break;
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot)//当交换时包含基准值时，为了保证不死循环，修正下标
                r--;
            if (arr[r] == pivot)
                l++;
        }
        if (l == r) {
            l++;
            r--;
        }
        quickSortHan(arr, left, r);
        quickSortHan(arr, l, right);
    }

    /**
     * 我尝试的快速排序
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSortTry(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int base = arr[(i + j) / 2];
        while (i < j) {
            while (arr[i] < base) {
                i++;
            }
            while (arr[j] > base) {
                j--;
            }
            if (i == j)
                break;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            if (arr[i] == base) {
                j--;
            }
            if (arr[j] == base) {
                i++;
            }
        }
        quickSortTry(arr, start, j - 1);
        quickSortTry(arr, i + 1, end);
    }

    /**
     * 非递归快排：利用栈
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSortNotRecurion(int[] arr, int left, int right) {
        //定义一个栈
        Stack<Integer> stack = new Stack<>();
        //前提条件就是left < right
        if (left < right) {
            stack.push(left);  //将left压进栈中
            stack.push(right);  //将right压进栈中
            while (!stack.isEmpty()) {  //当栈不为空时，进行以后的操作
                int height = stack.pop();  //取出栈中第一位，我最后压进的是right，所以它是最末位的下标；
                int low = stack.pop();  //最底下的是left的下标。到底哪个对应那个，要看你是怎么压进去的

                int index = getTargetIndex(arr, low, height);  //得到基准数的下标
                if (index - 1 > low) {   //判断基准数左边的数的下标与开始下标的大小
                    stack.push(low);    //根据情况压进去以基准数分开的下标的左半边部分的低位
                    stack.push(index - 1);   //根据情况压进去以基准数分开的下标的左半边部分的高位
                }

                if (index + 1 < height) {  //判断基准数右边的数的下标与开始下标的大小
                    stack.push(index + 1);   //根据情况压进去以基准数分开的下标的右半边部分的低位
                    stack.push(height);   //根据情况压进去以基准数分开的下标的右半边部分的高位
                }
            }
        }
    }

    private static int getTargetIndex(int[] arr, int left, int right) {
        if (left >= right || arr == null) {
            return -1;
        }

        int key = arr[left];
        while (left < right) {
            while (key < arr[right] && left < right)
                right--;
            arr[left] = arr[right];

            while (key >= arr[left] && left < right)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = key;
        System.out.println(left + "***");
        return left;
    }

    /**
     * 带泛型的快排
     *
     * @param arr
     * @param start
     * @param end
     */
    public static <T extends Number> void quickSort(T[] arr, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        T base = arr[start];
        while (i < j) {
            while (arr[j].longValue() >= base.longValue() && i < j) {
                j--;
            }
            while (arr[i].longValue() <= base.longValue() && i < j) {
                i++;
            }
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[start] = arr[i];
        arr[i] = base;
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }
}
