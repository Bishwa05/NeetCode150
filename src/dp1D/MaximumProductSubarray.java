package dp1D;

/**
 *
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * You can assume the output will fit into a 32-bit integer.
 *
 * Note that the product of an array with a single element is the value of that element.
 *
 * Example 1:
 *
 * Input: nums = [2,4,-3,5]
 * Output: 8
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int[] max = new int[n];
        int[] min = new int[n];

        max[0] = min[0] = nums[0];

        int res = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i]> 0) {
                max[i] = Math.max(nums[i], max[i-1]*nums[i]);
                min[i] = Math.min(nums[i], min[i-1]*nums[i]);
            } else {
                max[i] = Math.max(nums[i], min[i-1]*nums[i]);
                min[i] = Math.min(nums[i], max[i-1]*nums[i]);
            }

            res = Math.max(res, max[i]);
        }
        return res;
    }
}
