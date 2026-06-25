package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given an array nums of unique integers, return all the possible permutations.
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Example 2:
 * Input: nums = [7]
 * Output: [[7]]
 *
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayList<>(), new boolean[nums.length], res);
        return res;
    }

    private void dfs(int[] nums, List<Integer> temp, boolean[] used, List<List<Integer>> res) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                temp.add(nums[i]);
                used[i]= true;
                dfs(nums, temp, used, res);
                temp.remove(temp.size() -1);
                used[i]= false;
            }
        }
    }

    /**
     * BFS
     */
    public List<List<Integer>> permuteBFS(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        perms.add(new ArrayList<>());
        for (int num : nums){
            List<List<Integer>> newPerms = new ArrayList<>();

            for (List<Integer> p : perms) {
                for (int i = 0; i <= p.size(); i++) {
                    List<Integer> pCopy = new ArrayList<>();
                    pCopy.set(i, num);
                    newPerms.add(pCopy);
                }
            }
        perms = newPerms;
        }
        return perms;
    }
}
