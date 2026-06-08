package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://neetcode.io/problems/max-area-of-island/question?list=neetcode150
 *
 * You are given a matrix grid where grid[i] is either a 0 (representing water) or 1 (representing land).
 *
 * An island is defined as a group of 1's connected horizontally or vertically. You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is defined as the number of cells within the island.
 *
 * Return the maximum area of an island in grid. If no island exists, return 0.
 *
 */
public class MaxAreaOfIsland {
    int[][] DIRS = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;

        if(grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        int area = 1;

        for (int[] dir : DIRS) {
            area += dfs(grid, i + dir[0], j + dir[1]);
        }
        return area;
    }


    /**
     * BFS
     */

    public int maxAreaOfIslandBFS(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int area = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    area = Math.max(area, bfs(grid, r, c));
                }
            }
        }

        return area;
    }

    private int bfs(int[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = 0;
        q.add(new int[]{r, c});
        int res = 1;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];

            for (int[] dir : DIRS) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length &&
                        nc < grid[0].length && grid[nr][nc] == 1) {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = 0;
                    res++;
                }
            }
        }
        return res;
    }
}
