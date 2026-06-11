package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://neetcode.io/problems/generate-parentheses
 *
 * You are given an integer n. Return all well-formed parentheses strings that you can generate with n pairs of parentheses.
 *
 * Example 1:
 *
 * Input: n = 1
 *
 * Output: ["()"]
 * Example 2:
 *
 * Input: n = 3
 *
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(0, 0, n, "", res);
        return res;
    }

    private void dfs(int open, int close, int n, String temp, List<String> res) {
        if (temp.length() == 2*n) {
            res.add(temp);
            return;
        }

        if (open < n) dfs(open+1, close, n,temp+"(", res);
        if (close < open) dfs(open, close +1, n, temp+")", res);
    }

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        g.generateParenthesis(2).forEach(e -> System.out.println(e));
    }
}
