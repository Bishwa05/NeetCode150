package tree;

/**
 * You are given the root of a binary tree root. Invert the binary tree and return its root.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7]
 *
 * Output: [1,3,2,7,6,5,4]
 *
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
