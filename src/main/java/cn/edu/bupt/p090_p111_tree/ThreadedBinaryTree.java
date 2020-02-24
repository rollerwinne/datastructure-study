package cn.edu.bupt.p090_p111_tree;

public class ThreadedBinaryTree {
    /**
     * 中序线索化二叉树
     *
     * @param node
     */
    public static void inffixThreadedTree(ThreadedNode node) {
        ThreadedBinaryTree.inffixThreadedTree(node, null);
    }

    private static void inffixThreadedTree(ThreadedNode node, ThreadedNode pre) {
        if (node == null)
            return;
        inffixThreadedTree(node.left, pre);
        if (node.left == null) {
            node.left = pre;
            node.isLeftThread = true;
        }
        if (pre != null && pre.isRightThread) {
            pre.right = node;
            pre.isRightThread = true;
        }
        pre = node;
        inffixThreadedTree(node.right, pre);
    }

    /**
     * 中序遍历线索化二叉树
     * @param node
     */
    public static void inffixTraversal(ThreadedNode node) {
        if (node==null)
            return;
        while (node!=null){
            while (!node.isLeftThread){
                node=node.left;
            }
            System.out.println(node);
            while (node.isRightThread){
                System.out.println(node.right);
                node=node.right;
            }
            node=node.right;
        }
    }

    /**
     * 前序线索化二叉树
     *
     * @param node
     */
    public static void preThreadedTree(ThreadedNode node) {

    }
    /**
     * 前序遍历线索化二叉树
     * @param node
     */
    public static void preTraversal(ThreadedNode node) {
        
    }
    /**
     * 后序线索化二叉树
     *
     * @param node
     */
    public static void suffixThreadedTree(ThreadedNode node) {

    }
    /**
     * 后序遍历线索化二叉树
     * @param node
     */
    public static void suffixTraversal(ThreadedNode node) {
        
    }

    static class ThreadedNode {
        int value;
        ThreadedNode left;
        ThreadedNode right;
        boolean isLeftThread;
        boolean isRightThread;

        @Override
        public String toString() {
            return "ThreadedNode{" +
                    "value=" + value +
                    '}';
        }
    }
}


