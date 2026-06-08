package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * You are given a 2-D matrix grid. Each cell can have one of three possible values:
 *
 * 0 representing an empty cell
 * 1 representing a fresh fruit
 * 2 representing a rotten fruit
 * Every minute, if a fresh fruit is horizontally or vertically adjacent to a rotten fruit, then the fresh fruit also becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until there are zero fresh fruits remaining. If this state is impossible within the grid, return -1.
 *
 * Input: grid = [[1,1,0],[0,1,1],[0,1,2]]
 * Output: 4
 */
public class RottingFruit {
    int[][] DIRS = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int res = 0, fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }

                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (fresh > 0 && !q.isEmpty()) {
            int size = q.size();
            System.out.println(size);
            while (size > 0) {
                int[] node = q.poll();
                for (int[] dir : DIRS) {
                    int x = node[0] + dir[0];
                    int y = node[1] + dir[1];

                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.offer(new int[]{x, y});
                        fresh--;
                    }
                }
                size--;
            }
            res++;
        }

        return fresh == 0 ? res : -1;
    }
}
