package dp1D;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum/2;
        boolean[][] dp = new boolean[n+1][target+1];

        for (int i = 0; i <=n; i++){
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i-1] <= j) {
                    // Choice 2: Include the current element (if it fits)
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                } else {
                    // Choice 1: Exclude the current element
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        int[] nums = {1,2,3,4};
        p.canPartition(nums);
    }
}
