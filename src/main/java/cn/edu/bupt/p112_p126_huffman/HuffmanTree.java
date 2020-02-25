package cn.edu.bupt.p112_p126_huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Node root = createHuffmanTree(arr);
        preTraversal(root);
    }

    public static Node createHuffmanTree(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node temp = new Node(leftNode.value + rightNode.value);
            temp.left = leftNode;
            temp.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(temp);
        }
        return nodes.get(0);
    }

    static class Node implements Comparable<Node> {
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

        @Override
        public int compareTo(Node node) {
            return this.value - node.value;
        }
    }

    public static void preTraversal(Node node) {
        if (node == null)
            return;
        System.out.println(node);
        preTraversal(node.left);
        preTraversal(node.right);
    }
}
