package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * https://neetcode.io/problems/clone-graph
 *
 * Given a node in a connected undirected graph, return a deep copy of the graph.
 *
 * Each node in the graph contains an integer value and a list of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 * The graph is shown in the test cases as an adjacency list. An adjacency list is a mapping of nodes to lists, used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
 *
 * For simplicity, nodes values are numbered from 1 to n, where n is the total number of nodes in the graph. The index of each node within the adjacency list is the same as the node's value (1-indexed).
 *
 * The input node will always be the first node in the graph and have 1 as the value.
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        Map<Node, Node> cloneMap = new HashMap<>();
        Node newNode = dfs(node, cloneMap);
        return newNode;
    }

    public Node dfs(Node node, Map<Node, Node> cloneMap) {
        if (node == null) return null;

        if (cloneMap.containsKey(node)) return cloneMap.get(node);

        Node newNode = new Node(node.val);
        cloneMap.put(node, newNode);

        for (Node neighbour : node.neighbors) {
            newNode.neighbors.add(dfs(neighbour, cloneMap));
        }
        return newNode;
    }

    /**
     * BFS
     */
    public Node cloneGraphBFS(Node node) {
        if (node == null) return null;
        Map<Node, Node> cloneMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        cloneMap.put(node, new Node(node.val));

        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node neighbor : curr.neighbors) {
                if (!cloneMap.containsKey(neighbor)) {
                    cloneMap.put(neighbor, new Node(neighbor.val));
                    q.offer(neighbor);
                }

                cloneMap.get(curr).neighbors.add(cloneMap.get(neighbor));
            }
        }

        return cloneMap.get(node);
    }

}
