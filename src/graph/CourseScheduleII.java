package graph;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        int[] inDegree = new int[numCourses];
        int[] output = new int[numCourses];

        for (int[] pre : prerequisites) {
            List<Integer> l = preMap.getOrDefault(pre[0], new ArrayList<>());
            l.add(pre[1]);
            inDegree[pre[1]]++;
            preMap.put(pre[0], l);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int finish = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.println(curr);
            output[numCourses - finish - 1] = curr;
            finish++;
            if (!preMap.containsKey(curr)) continue;

            for (int nei : preMap.get(curr)) {
                inDegree[nei]--;
                if (inDegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        if (finish != numCourses) return new int[0];

        return output;
    }

    // DFS

    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereq = new HashMap<>();
        for (int[] pair : prerequisites) {
            prereq.computeIfAbsent(pair[0],
                    k -> new ArrayList<>()).add(pair[1]);
        }

        List<Integer> output = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, prereq, visit, cycle, output)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = output.get(i);
        }
        return result;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> prereq,
                        Set<Integer> visit, Set<Integer> cycle,
                        List<Integer> output) {

        if (cycle.contains(course)) {
            return false;
        }
        if (visit.contains(course)) {
            return true;
        }

        cycle.add(course);
        for (int pre : prereq.getOrDefault(course, Collections.emptyList())) {
            if (!dfs(pre, prereq, visit, cycle, output)) {
                return false;
            }
        }
        cycle.remove(course);
        visit.add(course);
        output.add(course);
        return true;
    }
}
