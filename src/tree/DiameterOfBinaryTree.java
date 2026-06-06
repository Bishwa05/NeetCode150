package tree;

/**
 * The diameter of a binary tree is defined as the length of the longest path between any two nodes within the tree. The path does not necessarily have to pass through the root.
 *
 * The length of a path between two nodes in a binary tree is the number of edges between the nodes. Note that the path can not include the same node twice.
 *
 * Given the root of a binary tree root, return the diameter of the tree.
 *
 */
public class DiameterOfBinaryTree {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int d = leftHeight + rightHeight;
        maxDiameter = Math.max(d, maxDiameter); //

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
