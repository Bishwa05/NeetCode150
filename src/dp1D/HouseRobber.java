package dp1D;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i]+ dp[i-2], dp[i-1]);
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        HouseRobber h = new HouseRobber();
        int[]nums= {5,1,2,10,6,2,7,9,3,1};
        System.out.println(h.rob(nums));
    }
}
