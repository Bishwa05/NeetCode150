package graph;

import java.util.*;

/**
 * You are given a 2-D integer array points, where points[i] = [xi, yi]. Each points[i] represents a distinct point on a 2-D plane.
 *
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between the two points, i.e. |xi - xj| + |yi - yj|.
 *
 * Return the minimum cost to connect all points together, such that there exists exactly one path between each pair of points.
 *
 * Input: points = [[0,0],[2,2],[3,3],[2,4],[4,2]]
 *
 * Output: 10
 */
public class MinCostToConnectPoints {
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;
        int res = 0;
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i+1; j < N; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                graph.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{dist, j});
                graph.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{dist, i});
            }
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        minheap.offer(new int[]{0, 0});

        while(visited.size() < N) {
            int[] curr = minheap.poll();
            int currIndex = curr[1];
            int currCost = curr[0];

            if (visited.contains(currIndex)) continue;
            visited.add(currIndex);
            res += currCost;
            for (int[] neighbour : graph.getOrDefault(currIndex, Collections.emptyList())) {
                int neighbourIndex = neighbour[1];
                int neighbourCost = neighbour[0];
                if (!visited.contains(neighbourIndex)) {
                    minheap.offer(new int[] {neighbourCost, neighbourIndex});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points={{2,2},{3,3},{2,4},{4,2}};
        MinCostToConnectPoints m = new MinCostToConnectPoints();
        System.out.println(m.minCostConnectPoints(points));
    }
}
