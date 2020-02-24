package cn.edu.bupt.p090_p111_tree;

import java.util.Arrays;

public class ArrayBinaryTree {
    /**
     * 数组转树
     *
     * @param arr
     * @return
     */
    public static TreeNode arrToTree(int[] arr) {
        return ArrayBinaryTree.arrToTree(arr, 0);
    }

    private static TreeNode arrToTree(int[] arr, int index) {
        if (arr == null || index >= arr.length)
            return null;
        TreeNode node = new TreeNode(arr[index]);
        node.left = arrToTree(arr, index * 2 + 1);
        node.right = arrToTree(arr, index * 2 + 2);
        return node;
    }

    /**
     * 树转数组
     *
     * @param node
     * @param size
     * @return
     */
    public static int[] treeToArr(TreeNode node, int size) {
        int[] arr = new int[size];
        treeToArr(node, arr, 0);
        return arr;
    }

    private static void treeToArr(TreeNode node, int[] arr, int index) {
        if (node == null || index >= arr.length)
            return;
        arr[index] = node.getValue();
        treeToArr(node.left, arr, index * 2 + 1);
        treeToArr(node.right, arr, index * 2 + 2);
    }

    /**
     * 数组前序遍历
     *
     * @param arr
     */
    public static void preTraversal(int[] arr) {
        ArrayBinaryTree.preTraversal(arr, 0);
    }

    private static void preTraversal(int[] arr, int index) {
        if (arr == null || index >= arr.length)
            return;
        System.out.println(arr[index]);
        preTraversal(arr, index * 2 + 1);
        preTraversal(arr, index * 2 + 2);
    }

    /**
     * 数组中序遍历
     *
     * @param arr
     */
    public static void inffixTraversal(int[] arr) {
        ArrayBinaryTree.inffixTraversal(arr, 0);
    }

    private static void inffixTraversal(int[] arr, int index) {
        if (arr == null || index >= arr.length)
            return;
        preTraversal(arr, index * 2 + 1);
        System.out.println(arr[index]);
        preTraversal(arr, index * 2 + 2);
    }

    /**
     * 数组后序遍历
     *
     * @param arr
     */
    public static void suffixTraversal(int[] arr) {
        ArrayBinaryTree.suffixTraversal(arr, 0);
    }

    public static void suffixTraversal(int[] arr, int index) {
        if (arr == null || index >= arr.length)
            return;
        preTraversal(arr, index * 2 + 1);
        preTraversal(arr, index * 2 + 2);
        System.out.println(arr[index]);
    }
}

class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        // ArrayBinaryTree.preTraversal(arr);
        // System.out.println("-----");
        // ArrayBinaryTree.inffixTraversal(arr);
        // System.out.println("-----");
        // ArrayBinaryTree.suffixTraversal(arr);

        System.out.println(Arrays.toString(arr));
        TreeNode node = ArrayBinaryTree.arrToTree(arr);
        int[] arr2 = ArrayBinaryTree.treeToArr(node, 7);
        System.out.println(Arrays.toString(arr2));
    }
}
