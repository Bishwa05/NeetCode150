package tree;

/**
 * Given the roots of two binary trees p and q, return true if the trees are equivalent, otherwise return false.
 *
 * Two binary trees are considered equivalent if they share the exact same structure and the nodes have the same values.
 *
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 */
public class SameBinaryTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
