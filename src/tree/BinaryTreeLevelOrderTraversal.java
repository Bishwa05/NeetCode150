package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree root, return the level order traversal of it as a nested list, where each sublist contains the values of nodes at a particular level in the tree, from left to right.
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [[1],[2,3],[4,5,6,7]]
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                currList.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            } else {
                result.add(new ArrayList<>(currList));
                currList = new ArrayList<>();
                if (!q.isEmpty()){
                    q.offer(null);
                }
            }
        }
        return result;
    }
}
