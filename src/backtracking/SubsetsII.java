package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://neetcode.io/problems/subsets-ii
 *
 * You are given an array nums of integers, which may contain duplicates. Return all possible subsets.
 *
 * The solution must not contain duplicate subsets. You may return the solution in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,1]
 *
 * Output: [[],[1],[1,2],[1,1],[1,2,1],[2]]
 * Example 2:
 *
 * Input: nums = [7,7]
 *
 * Output: [[],[7], [7,7]]
 *
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(0, nums.length, nums, res, new ArrayList<>());
        return res;
    }

    private void dfs(int start, int end, int[] nums, List<List<Integer>> res, List<Integer> temp) {
        res.add(new ArrayList<>(temp));

        for (int i = start; i < end; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;

            temp.add(nums[i]);
            dfs(i+1, nums.length, nums, res, temp);
            temp.remove(temp.size()-1);

        }
    }
}
