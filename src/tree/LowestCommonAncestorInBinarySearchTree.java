package tree;

/**
 *
 * Given a binary search tree (BST) where all node values are unique, and two nodes from the tree p and q, return the lowest common ancestor (LCA) of the two nodes.
 *
 * The lowest common ancestor between two nodes p and q is the lowest node in a tree T such that both p and q as descendants. The ancestor is allowed to be a descendant of itself.
 *
 * Input: root = [5,3,8,1,4,7,9,null,2], p = 3, q = 8
 *
 * Output: 5
 */
public class LowestCommonAncestorInBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return root;

        if (root == p || root == q) return root;

        if (Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (Math.min(p.val, q.val) > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while(cur != null) {
            if(p.val < cur.val && q.val < cur.val){
                cur = cur.left;
            } else if (p.val > cur.val && q.val > cur.val){
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return cur;
    }
}
