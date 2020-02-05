package cn.edu.bupt.p077_p085_search;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, -3, 12, 43, 0, 17, -3, 2};
        int index = linearSearch(arr, 5);
        System.out.println((index == -1) ? "不存在" : index);
    }

    public static int linearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }
}
