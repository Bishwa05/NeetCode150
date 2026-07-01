package dp2D;

import java.util.Arrays;

public class LongestIncreasingPathInMatrix {
    int[][] DIRS = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        int maxPath = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j));
            }
        }
        return maxPath;
    }

    private int dfs(int[][] matrix, int i, int j) {

        int path = 1;

        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];


            if (x < matrix.length && x >= 0 && y >= 0 && y < matrix[0].length && matrix[i][j] < matrix[x][y]) {
                path = Math.max(path, 1 + dfs(matrix, x, y));
            }
        }
        return path;
    }



    // memo
    public int longestIncreasingPath2(int[][] matrix) {
        int maxPath = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs2(matrix, i, j, memo));
            }
        }
        return maxPath;
    }

    private int dfs2(int[][] matrix, int i, int j, int[][] memo) {

        if (memo[i][j] != 0) return memo[i][j];


        int path = 1;

        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < matrix.length && x >= 0 && y >= 0 && y < matrix[0].length  && matrix[i][j] < matrix[x][y]) {
                path = Math.max(path, 1+ dfs2(matrix, x, y, memo));
            }
        }
        memo[i][j] = path;
        return path;
    }

    public static void main(String[] args) {
        int[][] matrix = {{5,5,3},{2,3,6},{1,1,1}};
        LongestIncreasingPathInMatrix l = new LongestIncreasingPathInMatrix();
        System.out.println(l.longestIncreasingPath(matrix));
    }
}
