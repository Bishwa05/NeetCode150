package graph;

import java.util.*;

/**
 *
 * https://neetcode.io/problems/valid-tree
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 *
 * Input:
 * n = 5
 * edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
 *
 * Output:
 * true
 *
 *
 * Input:
 * n = 5
 * edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
 *
 * Output:
 * false
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {

        if (n-1 != edges.length) return false;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visit = new HashSet<>();

        if (!dfs(0, -1, visit, adj)) {
            return false;
        }
        return visit.size() == n;
    }

    private boolean dfs(int node, int parent, Set<Integer> visit, List<List<Integer>> adj) {
        if (visit.contains(node)) return false;
        visit.add(node);

        for (int nei : adj.get(node)) {
            if (nei == parent) {
                continue;
            }

            if (!dfs(nei, node, visit, adj)) {
                return false;
            }
        }
        return true;
    }


    // BFS

    public boolean validTree2(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visit = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, -1});  // {current node, parent node}
        visit.add(0);

        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int node = pair[0], parent = pair[1];
            for (int nei : adj.get(node)) {
                if (nei == parent) {
                    continue;
                }
                if (visit.contains(nei)) {
                    return false;
                }
                visit.add(nei);
                q.offer(new int[]{nei, node});
            }
        }

        return visit.size() == n;
    }
}
