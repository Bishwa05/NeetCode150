package backtracking;
/**
 * https://neetcode.io/problems/combination-target-sum-ii
 *
 * You are given an array of integers candidates, which may contain duplicates, and a target integer target. Your task is to return a list of all unique combinations of candidates where the chosen numbers sum to target.
 *
 * Each element from candidates may be chosen at most once within a combination. The solution set must not contain duplicate combinations.
 *
 * You may return the combinations in any order and the order of the numbers in each combination can be in any order.
 *
 * Example 1:
 *
 * Input: candidates = [9,2,2,4,6,1,5], target = 8
 *
 * Output: [
 *   [1,2,5],
 *   [2,2,4],
 *   [2,6]
 * ]
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, target, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int i, int[]c, int target, List<Integer> temp, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
        }


        for (int j = i; j < c.length; j++) {
            if (j > i && c[j] == c[j-1]) continue;

            if (target -c[j]< 0) break;


            temp.add(c[j]);
            dfs(j+1, c, target-c[j], temp, res);
            temp.remove(temp.size() -1);

        }
    }
}
