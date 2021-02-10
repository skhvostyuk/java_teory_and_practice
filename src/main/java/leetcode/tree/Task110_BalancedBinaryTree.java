package leetcode.tree;

public class Task110_BalancedBinaryTree {

    /**
     * Given a binary tree, determine if it is height-balanced.
     * For this problem, a height-balanced binary tree is defined as:
     * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
     */
    public static boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(height(root.right) - height(root.left)) <= 1);
    }

    private static int height (TreeNode root) {
        if(root == null)
            return 0;
        int leftHeight = root.left == null ? 0 : height(root.left);
        int rightHeight = root.right == null ? 0 : height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
