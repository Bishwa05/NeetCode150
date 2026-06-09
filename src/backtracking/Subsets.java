package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://neetcode.io/problems/subsets
 *
 * Given an array nums of unique integers, return all possible subsets of nums.
 *
 * The solution set must not contain duplicate subsets. You may return the solution in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 *
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [7]
 *
 * Output: [[],[7]]
 *
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, nums.length, res, new ArrayList<>(), nums);
        return res;
    }

    private void dfs(int start, int end, List<List<Integer>> res, List<Integer> curr, int[] nums) {

        res.add(new ArrayList<>(curr));

        for (int i = start; i < end; i++) {
            curr.add(nums[i]);
            dfs(i+1, nums.length, res, curr, nums);
            curr.remove(curr.size() -1);
        }
    }


    // DFS Another approach
    /**
     * Maintain:
     *      res → final list of all subsets
     *      subset → current subset being built
     * Define a recursive function dfs(i):
     *      If i equals the length of the input:
     *          Add a copy of subset to res
     *          Return
     *      Choice 1: include nums[i]
     *          Append number to subset
     *          Recurse to next index
     *          Remove the number (backtrack)
     *      Choice 2: skip nums[i]
     *          Recurse to next index
     * Start recursion with dfs(0)
     * Return res
     */

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(nums, i + 1, subset, res);
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, subset, res);
    }


    // Iteration

    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(res.get(i));
                subset.add(num);
                res.add(subset);
            }
        }

        return res;
    }
}
