package cn.edu.bupt.p127_p134_binarysorttree;

import java.util.Arrays;
import java.util.List;

public class BinarySortTreeStatic {
    public static void main(String[] args) {
        int[] arr = {7};
        //int[] arr = {7, 3};
        Node node = createTree(arr);
        preOrder(node);
        Node node2 = delNode(node, 7);
        System.out.println("-----");
        preOrder(node2);
    }

    public static Node delNode(Node root, int value) {
        if (root == null)
            return null;
        List<Node> list = searchParent(root, value);
        Node targetNode = list.get(0);
        Node parentNode = list.get(1);
        if (targetNode == null)
            return root;
        if (root.left == null && root.right == null)
            return null;
        if (targetNode.left == null && targetNode.right == null) {//左右子树均为空
            if (parentNode.left == targetNode) {
                parentNode.left = null;
            } else {
                parentNode.right = null;
            }
        } else if (targetNode.left == null) {//左子树为空
            if (parentNode == null)
                return targetNode.right;
            if (parentNode.left == targetNode) {
                parentNode.left = targetNode.right;
            } else {
                parentNode.right = targetNode.right;
            }

        } else if (targetNode.right == null) {//右子树为空
            if (parentNode == null)
                return targetNode.left;
            if (parentNode.left == targetNode) {
                parentNode.left = targetNode.left;
            } else {
                parentNode.right = targetNode.left;
            }
        } else {//左右子树均不为空
            targetNode.value = delMinNode(root, targetNode.right);
        }
        return root;
    }

    private static int delMinNode(Node root, Node node) {
        if (node == null)
            throw new RuntimeException();
        Node temp = node;
        while (temp.left != null) {
            temp = temp.left;
        }
        delNode(root, temp.value);
        return temp.value;
    }

    public static List<Node> searchParent(Node node, int value) {
        return BinarySortTreeStatic.searchParent(node, value, null);
    }

    public static List<Node> searchParent(Node node, int value, Node parent) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            return Arrays.asList(node, parent);
        }
        if (value < node.value) {
            return searchParent(node.left, value, node);
        } else {
            return searchParent(node.right, value, node);
        }
    }

    public static Node search(Node node, int value) {
        if (node == null)
            return null;
        if (node.value == value) {
            return node;
        }
        if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }

    }

    public static Node createTree(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        Node node = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            add(node, arr[i]);
        }
        return node;
    }

    public static void add(Node node, int value) {
        if (node == null)
            throw new NullPointerException();
        if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                add(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                add(node.right, value);
            }
        }
    }

    public static void preOrder(Node node) {
        if (node == null)
            return;
        preOrder(node.left);
        System.out.println(node);
        preOrder(node.right);
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        // public void add(int value) {
        //     if (value < this.value) {
        //         if (this.left == null) {
        //             this.left = new Node(value);
        //         } else {
        //             this.left.add(value);
        //         }
        //     } else {
        //         if (this.right == null) {
        //             this.right = new Node(value);
        //         } else {
        //             this.right.add(value);
        //         }
        //     }
        // }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
