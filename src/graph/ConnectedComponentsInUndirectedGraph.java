package graph;

import java.util.List;
import java.util.ArrayList;

public class ConnectedComponentsInUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int counter = 0;
        int[] visited = new int[n];

        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }


        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) counter++;
            dfs(adjList, visited, i);
        }
        return counter;
    }

    private void dfs(List<Integer>[] adjList, int[] visited, int node) {
        visited[node] = 1;

        for (int i = 0; i < adjList[node].size(); i++) {
            if (visited[adjList[node].get(i)]==0) {
                dfs(adjList, visited, adjList[node].get(i));
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{1,2},{3,4}};
        ConnectedComponentsInUndirectedGraph c = new ConnectedComponentsInUndirectedGraph();
        System.out.println(c.countComponents(n, edges));
    }
}
