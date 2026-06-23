package dp1D;

/**
 * You are given an integer n representing the number of steps to reach the top of a staircase. You can climb with either 1 or 2 steps at a time.
 *
 * Return the number of distinct ways to climb to the top of the staircase.
 *
 * Example 1:
 *
 * Input: n = 2
 *
 * Output: 2
 *
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}
