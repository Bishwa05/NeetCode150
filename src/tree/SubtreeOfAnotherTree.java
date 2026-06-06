package tree;

/**
 *
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 *
 * Input: root = [1,2,3,4,5], subRoot = [2,4,5]
 *
 * Output: true
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // If the main tree is empty, it cannot contain a non-empty subtree
        if (root == null) return false;

        // 1. Check if the tree rooted at the current 'root' is identical to 'subRoot'
        if (isSameTree(root, subRoot)) return true;

        // 2. If not, recursively search in the left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null || root.val != subRoot.val) return false;

        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }
}
