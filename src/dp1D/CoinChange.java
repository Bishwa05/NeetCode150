package dp1D;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations (e.g. 1 dollar, 5 dollars, etc) and an integer amount representing a target amount of money.
 *
 * Return the fewest number of coins that you need to make up the exact target amount. If it is impossible to make up the amount, return -1.
 *
 * You may assume that you have an unlimited number of each coin.
 *
 * Example 1:
 * Input: coins = [1,5,10], amount = 12
 *
 * Output: 3
 * Explanation: 12 = 10 + 1 + 1. Note that we do not have to use every kind coin available.
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], 1 + dp[i-coins[j]]);
                }
            }
        }
        return (dp[amount] == amount+1)?-1: dp[amount];
    }
}
