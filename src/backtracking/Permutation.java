package backtracking;

import java.util.ArrayList;
import java.util.List;

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
