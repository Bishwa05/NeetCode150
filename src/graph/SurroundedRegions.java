package graph;

/**
 *
 * https://neetcode.io/problems/surrounded-regions
 *
 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
 *
 * Connect: A cell is connected to adjacent cells horizontally or vertically.
 * Region: To form a region connect every 'O' cell. Regions can have any shape; they do not need to be squares or rectangles.
 * Surround: A region is surrounded if none of the 'O' cells in that region are on the edge of the board. Such regions are completely enclosed by 'X' cells.
 * To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
 *
 * Example 1:
 *
 *
 *
 * Input: board = [
 *   ["X","X","X","X"],
 *   ["X","O","O","X"],
 *   ["X","X","O","X"],
 *   ["X","O","X","X"]
 * ]
 *
 * Output: [
 *   ["X","X","X","X"],
 *   ["X","X","X","X"],
 *   ["X","X","X","X"],
 *   ["X","O","X","X"]
 * ]
 *
 */
public class SurroundedRegions {
    int[][] DIRS = new int[][]{{1,0}, {0, 1}, {-1, 0}, {0, -1}};

    public void solve(char[][] board) {

        int ROWS = board.length;
        int COLS = board[0].length;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (i == 0 || i == ROWS-1 || j == 0 || j == COLS-1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (board[i][j] == 'X' || board[i][j] == '1') return;

        if (board[i][j] == 'O') board[i][j] = '1';

        for (int[] dir : DIRS) {
            dfs(board, i + dir[0], j + dir[1]);
        }
    }
}
