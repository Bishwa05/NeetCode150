package twopointer;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length-2; i++) {
            int target = -nums[i];
            if (nums[i] > 0) break;
            // if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    if(set.add(nums[i] + ":" +nums[j]+ ":"+nums[k])) {
                        result.add(List.of(nums[i], nums[j], nums[k]));
                    }

                    j++;
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={-2,0,1,1,2};
        ThreeSum t = new ThreeSum();
        List<List<Integer>> res = t.threeSum(nums);
    }
}
