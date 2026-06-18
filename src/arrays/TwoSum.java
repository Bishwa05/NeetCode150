package arrays;

/**
 * Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
 *
 * You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
 *
 * Return the answer with the smaller index first.
 *
 * Example 1:
 *
 * Input:
 * nums = [3,4,5,6], target = 7
 *
 * Output: [0,1]
 *
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length-1;

        while(i < j) {
            int sum = nums[i] + nums[j];
            if (sum > target) j--;
            else if (sum < target) i++;
            else return new int[]{i, j};
        }

        return new int[] {-1, -1};
    }
}
