package cn.edu.bupt.p090_p111_tree;

public class TreeSearchUtils {
    public static TreeNode preOrderSearch(TreeNode node, int value) {
        if (node == null)
            return null;
        if (node.getValue() == value)
            return node;
        TreeNode res = preOrderSearch(node.left, value);
        if (res != null)
            return res;
        return preOrderSearch(node.right, value);

    }

    public static TreeNode infixOrderSearch(TreeNode node, int value) {
        if (node == null)
            return null;
        TreeNode res = infixOrderSearch(node.left, value);
        if (res != null)
            return res;
        if (node.getValue() == value) {
            return node;
        }
        return infixOrderSearch(node.right, value);
    }

    public static TreeNode suffixOrderSearch(TreeNode node, int value) {
        if (node == null)
            return null;
        TreeNode res = suffixOrderSearch(node.left, value);
        if (res != null)
            return res;
        res = suffixOrderSearch(node.right, value);
        if (res != null)
            return res;
        if (node.getValue() == value)
            return node;
        return null;
    }
}
