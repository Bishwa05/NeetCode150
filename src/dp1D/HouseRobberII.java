package dp1D;

/**
 * https://neetcode.io/problems/house-robber-ii
 *
 * You are given an integer array nums where nums[i] represents the amount of money the ith house has. The houses are arranged in a circle, i.e. the first house and the last house are neighbors.
 *
 * You are planning to rob money from the houses, but you cannot rob two adjacent houses because the security system will automatically alert the police if two adjacent houses were both broken into.
 *
 * Return the maximum amount of money you can rob without alerting the police.
 *
 * Example 1:
 *
 * Input: nums = [3,4,3]
 *
 * Output: 4
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length ==0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int rob1 = robHelper(nums, 0, nums.length - 2);
        int rob2 = robHelper(nums, 1, nums.length - 1);
        return Math.max(rob1, rob2);
    }

    private int robHelper(int[]nums, int i, int j) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[i] = nums[i];
        dp[i+1] = Math.max(nums[i+1], dp[i]);

        for (int k = i+2; k <= j; k++) {
            dp[k] = Math.max(dp[k-2] + nums[k], dp[k-1]);
        }
        return dp[j];
    }
}
