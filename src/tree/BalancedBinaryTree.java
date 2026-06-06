package tree;

/**
 * Given a binary tree, return true if it is height-balanced and false otherwise.
 *
 * A height-balanced binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Input: root = [1,2,3,null,null,4]
 * Output: true
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return height(root) != -1;
    }

    private int height(TreeNode curr) {
        if (curr == null) return 0;

        int leftH = height(curr.left);

        if (leftH == -1) return -1;

        int rightH = height(curr.right);

        if (rightH == -1) return -1;

        if (Math.abs(leftH - rightH) > 1) return -1;

        return 1 + Math.max(leftH, rightH);
    }
}
