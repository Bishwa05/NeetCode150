package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://neetcode.io/problems/combination-target-sum
 *
 * You are given an array of distinct integers nums and a target integer target. Your task is to return a list of all unique combinations of nums where the chosen numbers sum to target.
 *
 * The same number may be chosen from nums an unlimited number of times. Two combinations are the same if the frequency of each of the chosen numbers is the same, otherwise they are different.
 *
 * You may return the combinations in any order and the order of the numbers in each combination can be in any order.
 *
 * Example 1:
 *
 * Input:
 * nums = [2,5,6,9]
 * target = 9
 *
 * Output: [[2,2,5],[9]]
 *
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, 0, target, res, new ArrayList<>());
        return res;
    }

    private void dfs(int i, int[] nums, int total, int target, List<List<Integer>> res, List<Integer> currList) {

        if (total == target) {
            res.add(new ArrayList<>(currList));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (total +  nums[j]> target) return;
            currList.add(nums[j]);
            dfs(j, nums, total+ nums[j], target, res, currList);
            currList.remove(currList.size()-1);

        }
    }
}
