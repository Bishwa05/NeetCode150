package graph;

import java.util.PriorityQueue;

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] DIRS = new int[][] {{1,0}, {0,1}, {-1,0}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.offer(new int[] {0, 0, grid[0][0]});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int max = curr[2];

            for (int[] dir : DIRS) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX < 0 || newX >= n || newY < 0 || newY >=n) continue;

                if (!visited[newX][newY]) {
                    visited[newX][newY] = true;
                    int newMax = Math.max(max, grid[newX][newY]);

                    if (newX== n-1 && newY == n-1) return newMax;
                    pq.offer(new int[]{newX, newY, newMax});
                }
            }
        }
        return 0;
    }
}
