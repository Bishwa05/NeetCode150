package graph;

/**
 *
 * https://neetcode.io/problems/course-schedule/question
 *
 * You are given an array prerequisites where prerequisites[i] = [a, b] indicates that you must take course b first if you want to take course a.
 *
 * The pair [0, 1], indicates that must take course 1 before taking course 0.
 *
 * There are a total of numCourses courses you are required to take, labeled from 0 to numCourses - 1.
 *
 * Return true if it is possible to finish all courses, otherwise return false.
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[0,1]]
 *
 * Output: true
 */

import java.util.*;

public class CourseSchedule {
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int[] pre : prerequisites) {
            if (preMap.containsKey(pre[1])) {
                preMap.get(pre[1]).add(pre[0]);
            } else {
                List<Integer> next = new ArrayList<>();
                next.add(pre[0]);
                preMap.put(pre[1], next);
            }
        }

        for (int curr = 0; curr< numCourses; curr++) {
            if (!dfs(curr, visiting, preMap)) return false;
        }

        return true;
    }

    private boolean dfs(int curr, Set<Integer> visiting, Map<Integer, List<Integer>> graph) {
        if (visiting.contains(curr)) return false; // cycle detected

        if (graph.get(curr) == null) return true;

        visiting.add(curr);

        for(int pre : graph.get(curr)) {
            if (!dfs(pre, visiting, graph)) return false;
        }

        visiting.remove(curr);
        graph.put(curr, null);
        return true;
    }


    /**
     *
     * Build a graph and compute indegree (number of prerequisites) for each course.
     * Add all courses with indegree = 0 into a queue.
     * While the queue is not empty:
     *      Remove a course from the queue.
     *      Mark it as finished.
     *      Reduce the indegree of its dependent courses.
     *      If any dependent course reaches indegree = 0, add it to the queue.
     *
     * After processing:
     *      If finished courses == total courses - return true
     *      Else - return false
     *
     */
    // Khan's Algorithm
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[numCourses];

        // Indegree calc
        for (int[] pre : prerequisites) {
            List<Integer> l = adj.getOrDefault(pre[1], new ArrayList<>());
            l.add(pre[0]);
            inDegree[pre[0]]++;
            adj.put(pre[1], l);
        }

        // Add all the indegree 0 to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        int finish = 0;

        //Now BFS, breaking the connections in graph.
        while (!q.isEmpty()) {
            int curr = q.poll();
            finish++;
            if (!adj.containsKey(curr)) continue;

            for(int nei : adj.get(curr)) {
                inDegree[nei]--;
                if (inDegree[nei] == 0) q.offer(nei);
            }
        }
        return finish == numCourses;
    }
}
