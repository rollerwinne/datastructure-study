package cn.edu.bupt.p090_p111_tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node4.right = node7;

        // TreeTraversalUtils.preTraversal(node1);
        // System.out.println("----------");
        // TreeTraversalUtils.preTraversalStack(node1);
        // System.out.println("----------");
        // TreeTraversalUtils.infixTraversal(node1);
        // System.out.println("----------");
        // TreeTraversalUtils.infixTraversalStack(node1);
        // System.out.println("----------");
        // TreeTraversalUtils.suffixTraversal(node1);
        // System.out.println("----------");
        // TreeTraversalUtils.suffixTraversalStack(node1);
        // System.out.println("----------");
        // TreeTraversalUtils.levelTraversal(node1);

        // for (int i = 1; i < 8; i++) {
        //     System.out.println(TreeSearchUtils.preOrderSearch(node1, i));
        //     System.out.println(TreeSearchUtils.infixOrderSearch(node1, i));
        //     System.out.println(TreeSearchUtils.suffixOrderSearch(node1, i));
        // }

        TreeDeleteNodeUtils.setRoot(node1);
        TreeTraversalUtils.preTraversal(TreeDeleteNodeUtils.getRoot());
        TreeDeleteNodeUtils.deleteNode(3);
        System.out.println("---------");
        TreeTraversalUtils.preTraversal(TreeDeleteNodeUtils.getRoot());
    }
}
