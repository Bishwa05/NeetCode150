package linkedlist;

/**
 * https://neetcode.io/problems/find-duplicate-integer
 *
 * You are given an array of integers nums containing n + 1 integers. Each integer in nums is in the range [1, n] inclusive.
 *
 * There is exactly one repeated integer in nums, and every other integer appears at most once.
 *
 * Return the repeated integer.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,2,2]
 *
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3,4,4]
 *
 * Output: 4
 *
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[Math.abs(nums[i])-1] < 0) {
                return Math.abs(nums[i]);
            }
            nums[Math.abs(nums[i])-1] = nums[Math.abs(nums[i])-1] * -1;
        }
        return -1;
    }

// Another way
    public int findDuplicate2(int[] nums) {
        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            if (nums[idx] < 0) {
                return Math.abs(num);
            }
            nums[idx] *= -1;
        }
        return -1;
    }
}
