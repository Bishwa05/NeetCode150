package tree;

/**
 *
 * https://neetcode.io/problems/binary-tree-maximum-path-sum/question?list=neetcode150
 *
 * Given the root of a non-empty binary tree, return the maximum path sum of any non-empty path.
 *
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes has an edge connecting them. A node can not appear in the sequence more than once. The path does not necessarily need to include the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Input: root = [1,2,3]
 *
 * Output: 6
 */
public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSumRec(root);
        return maxSum;
    }

    private int maxSumRec(TreeNode node) {
        if (node == null) return 0;

        // max from left and right subtree
        int maxSumLeft = maxSumRec(node.left);
        int maxSumRight = maxSumRec(node.right);

        // ignore -ve subtree sum
        maxSumLeft = Math.max(maxSumLeft, 0);
        maxSumRight = Math.max(maxSumRight, 0);

        // max path sum at current node
        int maxSumLocal = maxSumLeft + maxSumRight + node.val;

        // Update global result with the best path through node.
        maxSum = Math.max(maxSum, maxSumLocal);

        // left or right subtree sum + current node
        return Math.max(maxSumLeft, maxSumRight) + node.val;
    }
}
