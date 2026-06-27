package dp2D;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            grid[i][0] = 1;
        }

        for (int j = 0; j <= n; j++) {
            grid[0][j] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i-1][j] == grid[i][j-1]) {
                    grid[i][j] = 1+ grid[i][j-1];
                } else {
                    grid[i][j] += grid[i][j-1] + grid[i-1][j];
                }
            }
        }

        return grid[m][n];
    }

    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
        System.out.println(u.uniquePaths(3, 6));
    }
}
