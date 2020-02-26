package cn.edu.bupt.p135_p145_avl;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {

    private Node root;

    public static void main(String[] args) {
        int[] arr = {10, 11, 7, 6, 8, 9};
        AVLTree avlTree = new AVLTree();
        avlTree.createTree(arr);
        System.out.println("中序遍历");
        avlTree.infixOrder();

        System.out.println("在平衡处理~~");
        System.out.println("树的高度=" + avlTree.getHeight()); //3
        System.out.println("树的左子树高度=" + getHeight(avlTree.root.left)); // 2
        System.out.println("树的右子树高度=" + getHeight(avlTree.root.right)); // 2
        System.out.println("当前的根结点=" + avlTree.root);//8
    }

    private void delNode(int value){
        delNode(root,value);
    }
    
    private static void delNode(Node node,int value){

    }

    private static void rightRotate(Node node) {
        Node newNode = new Node(node.value);
        newNode.right = node.right;
        newNode.left = node.left.right;
        node.value = node.left.value;
        node.left = node.left.left;
        node.right = newNode;
    }

    private static void leftRotate(Node node) {
        Node newNode = new Node(node.value);
        newNode.left = node.left;
        newNode.right = node.right.left;
        node.value = node.right.value;
        node.left = newNode;
        node.right = node.right.right;
    }

    public Node search(int value) {
        return this.search(root, value);
    }

    private static Node search(Node node, int value) {
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

    private void createTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            root = null;
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            this.add(arr[i]);
        }
    }

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        add(root, value);
    }

    private static void add(Node node, int value) {
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
        if (getHeight(node.left) - getHeight(node.right) > 1) {
            if (getHeight(node.left.right) > getHeight(node.left.left)) {
                leftRotate(node.left);
            }
            rightRotate(node);
        } else if (getHeight(node.right) - getHeight(node.left) > 1) {
            if (getHeight(node.right.left) > getHeight(node.right.right)) {
                rightRotate(node.right);
            }
            leftRotate(node);
        }
    }

    private int getHeight() {
        return getHeight(root);
    }

    private static int getHeight(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private static int getHeightQueue(Node node) {
        if (node == null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int height = 0;
        int count = 0;
        int size = 1;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
            count++;
            if (count == size) {
                size = queue.size();
                count = 0;
                height++;
            }
        }
        return height;
    }

    public void infixOrder() {
        this.preOrder(root);
    }

    private static void preOrder(Node node) {
        if (node == null)
            return;
        preOrder(node.left);
        System.out.println(node);
        preOrder(node.right);
    }
}

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}