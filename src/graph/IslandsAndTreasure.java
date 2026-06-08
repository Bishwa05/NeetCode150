package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a
 * m
 * ×
 * n
 * m×n 2D grid initialized with these three possible values:
 *
 * -1 - A water cell that can not be traversed.
 * 0 - A treasure chest.
 * INF - A land cell that can be traversed. We use the integer 2^31 - 1 = 2147483647 to represent INF.
 * Fill each land cell with the distance to its nearest treasure chest. If a land cell cannot reach a treasure chest then the value should remain INF.
 *
 * Assume the grid can only be traversed up, down, left, or right.
 *
 * Modify the grid in-place.
 *
 */
public class IslandsAndTreasure {

    int[][] DIRS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        boolean [][] visited = new boolean[ROWS][COLS];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(visited, grid, i, j, 0);
                    // fill the matrix with false and make it available for next 0
                    for (boolean[] row : visited) {
                        Arrays.fill(row, false);
                    }
                }
            }
        }
    }

    private void dfs(boolean[][] visited, int[][] grid, int i, int j, int curr) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1) return;
        if (visited[i][j] && grid[i][j] < curr) return;

        visited[i][j] = true;
        if (grid[i][j] > curr) {
            grid[i][j] = curr;
        }
        curr = curr + 1;

        for (int[] dir : DIRS) {
            dfs(visited, grid, i + dir[0], j+dir[1], curr);
        }
    }


    /**
     *  Multi Source BFS
     */
    public void islandsAndTreasureMBFS(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] { i, j });
                }
            }
        }
        if (q.size() == 0) return;

        int[][] dirs = { { -1, 0 }, { 0, -1 },
                { 1, 0 }, { 0, 1 } };
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= m || c >= n || r < 0 ||
                        c < 0 || grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                q.add(new int[] { r, c });

                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}
