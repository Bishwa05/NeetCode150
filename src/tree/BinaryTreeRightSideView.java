package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You are given the root of a binary tree. Return only the values of the nodes that are visible from the right side of the tree, ordered from top to bottom.
 * Input: root = [1,2,3,null,4,null,5]
 * Output: [1,3,5]
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
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
                int n = currList.size()-1;
                result.add(currList.get(n));

                if (!q.isEmpty()) {
                    q.offer(null);
                }
            }
        }

        return result;
    }
}
