package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return true if it is a valid binary search tree, otherwise return false.
 *
 * A valid binary search tree satisfies the following constraints:
 *
 * The left subtree of every node contains only nodes with keys less than the node's key.
 * The right subtree of every node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees are also binary search trees.
 *
 * Input: root = [2,1,3]
 *
 * Output: true
 */
public class ValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, int minVal, int maxVal) {
        if (node == null) return true;

        if (minVal >= node.val || node.val >= maxVal) return false;

        return isValid(node.left,minVal, node.val) && isValid(node.right, node.val, maxVal);
    }



    // BFS
    public boolean isValidBSTBFS(TreeNode root){

        if (root == null) return true;

        Queue<Pair<TreeNode>> q = new LinkedList<>();
        q.offer(new Pair<>(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        while (!q.isEmpty()) {
            Pair<TreeNode> p = q.poll();
            TreeNode node = p.treeNode;
            if (p.min >= node.val || node.val >= p.max) return false;

            if (node.left != null) {
                q.offer(new Pair<>(node.left, p.min, node.val));
            }
            if (node.right != null) {
                q.offer(new Pair<>(node.right, node.val, p.max));
            }
        }
        return true;
    }

    static class Pair<T> {
        TreeNode treeNode;
        int min;
        int max;
        Pair(TreeNode t, int mi, int ma) {
            treeNode =  t;
            min = mi;
            max = ma;
        }
    }
}
