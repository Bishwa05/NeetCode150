package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {


    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(0, s, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int start, String s, List<String> partition, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(partition));
            return;
        }

        for (int i = start+1; i <= s.length(); i++) {
            String newString = s.substring(start, i);
            if (isPalindrome(newString)) {
                partition.add(newString);
                dfs(i, s, partition, res);
                partition.remove(partition.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() -1;
        while(i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
