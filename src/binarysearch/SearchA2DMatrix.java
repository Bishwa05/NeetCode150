package binarysearch;

/**
 * https://neetcode.io/problems/search-2d-matrix
 *
 * You are given an m x n 2-D integer array matrix and an integer target.
 *
 * Each row in matrix is sorted in non-decreasing order.
 * The first integer of every row is greater than the last integer of the previous row.
 * Return true if target exists within matrix or false otherwise.
 *
 * Can you write a solution that runs in O(log(m * n)) time?
 *
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int l = 0, r = ROWS * COLS - 1;

        while (l <= r) {
            int mid = (l + r)/2;
            int row = mid / COLS;
            int col = mid % COLS;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                r = mid -1;
            } else {
                l = mid +1;
            }
        }
        return false;
    }
}
