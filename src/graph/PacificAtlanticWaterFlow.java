package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You are given a rectangular island heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 *
 * The islands borders the Pacific Ocean from the top and left sides, and borders the Atlantic Ocean from the bottom and right sides.
 *
 * Water can flow in four directions (up, down, left, or right) from a cell to a neighboring cell with height equal or lower. Water can also flow into the ocean from cells adjacent to the ocean.
 *
 * Find all cells where water can flow from that cell to both the Pacific and Atlantic oceans. Return it as a 2D list where each element is a list [r, c] representing the row and column of the cell. You may return the answer in any order.
 *
 * Example 1:
 *
 *
 *
 * Input: heights = [
 *   [4,2,7,3,4],
 *   [7,4,6,4,7],
 *   [6,3,5,3,6]
 * ]
 *
 * Output: [[0,2],[0,4],[1,0],[1,1],[1,2],[1,3],[1,4],[2,0]]
 *
 */
public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();

        for (int i = 0; i < ROWS; i++) {
            pacQ.add(new int[]{i, 0});
            atlQ.add(new int[]{i, COLS-1});
        }

        for (int j = 0; j < COLS; j++) {
            pacQ.add(new int[]{0, j});
            atlQ.add(new int[]{ROWS-1, j});
        }

        bfs(pacQ, pac, heights);
        bfs(atlQ, atl, heights);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (pac[i][j] && atl[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private void bfs(Queue<int[]> q, boolean[][] mat, int[][] heights) {
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0], c = node[1];
            mat[r][c] = true;

            for (int[] dir : DIRS) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >=0 && nr < heights.length && nc >= 0 && nc < heights[0].length
                        && !mat[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
