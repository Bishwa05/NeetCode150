package graph;

import java.util.*;

/**
 *
 * You are given a network of n directed nodes, labeled from 1 to n. You are also given times, a list of directed edges where times[i] = (ui, vi, ti).
 *
 * ui is the source node (an integer from 1 to n)
 * vi is the target node (an integer from 1 to n)
 * ti is the time it takes for a signal to travel from the source to the target node (an integer greater than or equal to 0).
 * You are also given an integer k, representing the node that we will send a signal from.
 *
 * Return the minimum time it takes for all of the n nodes to receive the signal. If it is impossible for all the nodes to receive the signal, return -1 instead.
 *
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] edge : times) {
            graph.computeIfAbsent(edge[0], l -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        queue.offer(new int[] {k, 0});

        int[] distances = new int[n+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;

        while(queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (graph.containsKey(currentNode)) {
                for (int[] neighbour : graph.get(currentNode)) {
                    int neighbourNode = neighbour[0];
                    int neighbourDistance = currentDistance + neighbour[0];
                    if (neighbourDistance < distances[neighbourNode]) {
                        queue.offer(new int[]{neighbourNode, neighbourDistance});
                    }
                }
            }
        }

        int maxDistance = Arrays.stream(distances).skip(1).max().getAsInt();
        return maxDistance == Integer.MAX_VALUE? -1 : maxDistance;
    }
}
