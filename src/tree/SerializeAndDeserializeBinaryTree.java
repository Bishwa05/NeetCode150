package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Implement an algorithm to serialize and deserialize a binary tree.
 *
 * Serialization is the process of converting an in-memory structure into a sequence of bits so that it can be stored or sent across a network to be reconstructed later in another computer environment.
 *
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure. There is no additional restriction on how your serialization/deserialization algorithm should work.
 *
 * Note: The input/output format in the examples is the same as how NeetCode serializes a binary tree. You do not necessarily need to follow this format.
 *
 */
public class SerializeAndDeserializeBinaryTree {
    /**
     * BFS
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) sb.append("N,");
            else {
                sb.append(node.val).append(",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        if (vals[0].equals("N")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int index = 1;

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if (!vals[index].equals("N")){
                node.left = new TreeNode(Integer.parseInt(vals[index]));
                q.offer(node.left);
            }
            index++;

            if (!vals[index].equals("N")){
                node.right = new TreeNode(Integer.parseInt(vals[index]));
                q.offer(node.right);
            }
            index++;
        }
        return root;
    }

    /*
    DFS
     */

    public String recSerialize(TreeNode node, String str) {
        if (node == null) str += "N";
        else {
            str += node.val + ",";
            recSerialize(node.left, str);
            recSerialize(node.right, str);
        }
        return str;
    }

    public String serializeDFS(TreeNode root) {
        return recSerialize(root, "");
    }

    public TreeNode recDeserializeDFS(List<String> vals) {
        if (vals.get(0).equals("N")) {
            vals.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals.get(0)));
        vals.remove(0);
        node.left = recDeserializeDFS(vals);
        node.right = recDeserializeDFS(vals);
        return node;
    }

    public TreeNode deserializeDFS(String data) {
        String [] vals = data.split(",");
        List<String> strVals = Arrays.asList(vals);
        return recDeserializeDFS(strVals);
    }
}
