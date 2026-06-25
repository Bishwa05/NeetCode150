package backtracking;

/**
 * Given a 2-D grid of characters board and a string word, return true if the word is
 * present in the grid, otherwise return false.
 *
 * For the word to be present it must be possible to form it with a path in the board with
 * horizontally or vertically neighboring cells. The same cell may not be used more than
 * once in a word.
 *
 * Input:
 * board = [
 *   ["A","B","C","D"],
 *   ["S","A","A","T"],
 *   ["A","C","A","E"]
 * ],
 * word = "CAT"
 *
 * Output: true
 */
public class WordSearch {
    int[][] DIRS = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i , int j, String word, int k) {

        if (k == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j>= board[0].length) return false;


        if (board[i][j] != word.charAt(k) || board[i][j] == '#') return false;

        board[i][j] = '#';
        boolean res = false;
        for (int[] dir : DIRS) {
            res = res || dfs(board, i + dir[0], j + dir[1], word, k+1);
        }
        board[i][j] = word.charAt(k);

        return res;
    }
}
