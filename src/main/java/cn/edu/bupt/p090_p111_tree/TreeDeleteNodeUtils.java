package cn.edu.bupt.p090_p111_tree;

public class TreeDeleteNodeUtils {
    private static TreeNode root;

    public static void setRoot(TreeNode root) {
        TreeDeleteNodeUtils.root = root;
    }

    public static TreeNode getRoot() {
        return root;
    }

    public static boolean deleteNode(int value) {
        if (root == null)
            return false;
        if (root.getValue() == value) {
            root = null;
            return true;
        } else
            return deleteNode(root, value);
    }

    private static boolean deleteNode(TreeNode node, int value) {
        if (node == null)
            return false;
        if (node.left != null && node.left.getValue() == value) {
            node.left = null;
            return true;
        }
        if (node.right != null && node.right.getValue() == value) {
            node.right = null;
            return true;
        }
        boolean res=deleteNode(node.left,value);
        if (res)
            return true;
        return deleteNode(node.right,value);

    }
}
