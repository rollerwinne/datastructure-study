package cn.edu.bupt.p090_p111_tree;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 树的遍历
 */
public class TreeTraversalUtils {
    /**
     * 前序遍历（递归）
     *
     * @param node
     */
    public static void preTraversal(TreeNode node) {
        if (node == null)
            return;
        System.out.println(node);
        preTraversal(node.left);
        preTraversal(node.right);
    }

    /**
     * 前序遍历（非递归）
     *
     * @param node
     */
    public static void preTraversalStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            System.out.println(temp);
            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);
        }
    }

    /**
     * 中序遍历(递归)
     *
     * @param node
     */
    public static void infixTraversal(TreeNode node) {
        if (node == null)
            return;
        infixTraversal(node.left);
        System.out.println(node);
        infixTraversal(node.right);
    }

    /**
     * 中序遍历（非递归）
     *
     * @param node
     */
    public static void infixTraversalStack(TreeNode node) {
        if (node == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = node;
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.println(temp);
                temp = temp.right;
            }
        }
    }

    /**
     * 后序遍历（递归）
     *
     * @param node
     */
    public static void suffixTraversal(TreeNode node) {
        if (node == null)
            return;
        suffixTraversal(node.left);
        suffixTraversal(node.right);
        System.out.println(node);
    }

    /**
     * 后序遍历(非递归)
     * http://blog.csdn.net/qiuxinfa123/article/details/84880786
     *
     * @param node
     */
    public static void suffixTraversalStack(TreeNode node) {
        if (node == null)
            return;
        TreeNode temp = node;  //当前节点
        TreeNode pre = null; //上一次访问的节点
        Stack<TreeNode> s = new Stack<>();
        while (temp != null || !s.empty()) {
            while (temp != null) { //1.将根节点及其左孩子入栈
                s.push(temp);
                temp = temp.left;
            }
            if (!s.empty()) {
                temp = s.peek();//2.获取栈顶元素值
                if (temp.right == null || temp.right == pre) {//3.没有右孩子，或者右孩子已经被访问过
                    temp = s.pop();///则可以访问栈顶元素
                    System.out.println(temp);
                    pre = temp; //标记上一次访问的节点
                    temp = null;
                } else { //4.存在没有被访问的右孩子
                    temp = temp.right;
                }
            }
        }
    }

    /**
     * 层次遍历(队列)
     *
     * @param node
     */
    public static void levelTraversal(TreeNode node) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.println(temp);
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
    }

    /**
     * 层次遍历(递归)
     * https://blog.csdn.net/weixin_40119167/article/details/96150882）
     *
     * @param root
     */
    public List<List<TreeNode>> levelTraversalRecurtion(TreeNode root) {
        LinkedList<List<TreeNode>> result = new LinkedList<>();
        levelRecursion(root, result, 0);
        return result;
    }

    private void levelRecursion(TreeNode node, LinkedList<List<TreeNode>> result, int level) {
        if (node == null)
            return;
        if (result.size() < level + 1) {// 说明还需要添加一行
            result.addFirst(new ArrayList<>());
        }
        result.get(result.size() - 1 - level).add(node);
        levelRecursion(node.left, result, level + 1);
        levelRecursion(node.right, result, level + 1);
    }
}
