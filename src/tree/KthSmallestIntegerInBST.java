package tree;

public class KthSmallestIntegerInBST {
    int count = 0;
    int val = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }

    private void inOrder(TreeNode node, int k) {

        if (node.left != null) {
            inOrder(node.left, k);
        }
        count+=1;

        if (count == k) val = node.val;

        if (node.right != null) {
            inOrder(node.right, k);
        }
    }


    // Moris Traversal

    public int kthSmallest2(TreeNode root, int k) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                k--;
                if (k == 0) return curr.val;
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr)
                    pred = pred.right;

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    k--;
                    if (k == 0) return curr.val;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}
