package cn.edu.bupt.p127_p134_binarysorttree;

import java.util.Arrays;
import java.util.List;

/**
 * 二叉排序树/二叉搜索树/二叉查找树
 */
public class BinarySortTree {
    private Node root;

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        // int[] arr = {7, 3};
        BinarySortTree tree = new BinarySortTree();
        tree.createTree(arr);
        tree.inffixOrder();
        tree.delNode(7);
        System.out.println("-----");
        tree.inffixOrder();
    }

    /**
     * 删除二叉排序树的节点
     *
     * @param value
     */
    public void delNode(int value) {
        if (root == null) //树空
            return;
        List<Node> list = searchParent(value);
        Node targetNode = list.get(0);
        Node parentNode = list.get(1);
        if (targetNode == null) //没有找到该节点
            return;

        if (targetNode.left == null && targetNode.right == null) {//左右子树均为空
            if (parentNode == null) {//根节点
                root = null;
                return;
            }
            if (parentNode.left == targetNode) {
                parentNode.left = null;
            } else {
                parentNode.right = null;
            }
        } else if (targetNode.left == null) {//左子树为空,右子树不为空
            if (parentNode == null) {//根节点
                root = targetNode.right;
                return;
            }
            if (parentNode.left == targetNode) {
                parentNode.left = targetNode.right;
            } else {
                parentNode.right = targetNode.right;
            }
        } else if (targetNode.right == null) {//右子树为空,左子树不为空
            if (parentNode == null) {//根节点
                root = targetNode.left;
                return;
            }
            if (parentNode.left == targetNode) {
                parentNode.left = targetNode.left;
            } else {
                parentNode.right = targetNode.left;
            }
        } else {//左右子树均不为空
            targetNode.value = delMinNode(targetNode.right);
            // targetNode.value = delMaxNode(targetNode.left);
        }
    }

    private int delMinNode(Node node) {
        if (node == null)
            throw new RuntimeException();
        Node temp = node;
        while (temp.left != null) {
            temp = temp.left;
        }
        delNode(temp.value);
        return temp.value;
    }

    private int delMaxNode(Node node) {
        if (node == null)
            throw new RuntimeException();
        Node temp = node;
        while (temp.right != null) {
            temp = temp.right;
        }
        delNode(temp.value);
        return temp.value;
    }

    /**
     * 查找节点与父节点，返回到list中
     *
     * @param value
     * @return
     */
    private List<Node> searchParent(int value) {
        return this.searchParent(root, value, null);
    }

    private List<Node> searchParent(Node node, int value, Node parent) {
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

    /**
     * 二叉排序树的查找
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        return this.search(root, value);
    }

    private Node search(Node node, int value) {
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

    /**
     * 二叉排序树增加节点
     *
     * @param value
     */
    public void add(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        add(root, value);
    }

    private void add(Node node, int value) {
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

    /**
     * 二叉排序树的中序遍历
     */
    public void inffixOrder() {
        this.inffixOrder(root);
    }

    private void inffixOrder(Node node) {
        if (node == null)
            return;
        inffixOrder(node.left);
        System.out.println(node);
        inffixOrder(node.right);
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
