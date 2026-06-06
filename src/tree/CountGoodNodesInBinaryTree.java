package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * https://neetcode.io/problems/count-good-nodes-in-binary-tree/question
 *
 * Within a binary tree, a node x is considered good if the path from the root of the tree to the node x contains no nodes with a value greater than the value of node x
 *
 * Given the root of a binary tree root, return the number of good nodes within the tree.
 * Input: root = [2,1,1,3,null,1,5]
 * Output: 3
 */
public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode node, int max_val) {
        if (node == null) return 0;

        int res =  (node.val >= max_val)? 1 : 0;

        max_val = Math.max(max_val, node.val);

        res = res +  dfs(node.left, max_val);
        res = res + dfs(node.right, max_val);
        return res;
    }

    // BFS approach
    public int goodNodesBFS(TreeNode root) {
        int res = 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, Integer.MIN_VALUE));

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> p = q.poll();
            TreeNode node = p.treeNode;

            if (node.val >= p.maxVal) {
                res++;
            }

            int maxVal = Math.max(p.maxVal, node.val);

            if (node.left != null) q.offer(new Pair<>(node.left, maxVal));
            if (node.right != null) q.offer(new Pair<>(node.right, maxVal));
        }
        return res;
    }

    static class Pair<T, I> {
        TreeNode treeNode;
        Integer maxVal;

        Pair(TreeNode t, Integer i) {
            this.treeNode = t;
            this.maxVal = i;
        }
    }
}
