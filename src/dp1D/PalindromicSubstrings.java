package dp1D;

/**
 *
 * Given a string s, return the number of substrings within s that are palindromes.
 * A palindrome is a string that reads the same forward and backward.
 *
 * Example 1:
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: "a", "b", "c".
 *
 * Example 2:
 *
 * Input: s = "aaa"
 * Output: 6
 *
 */
public class PalindromicSubstrings {
    private int checkPalindrome(String s, int low, int high) {
        int len = s.length();
        int count = 0;

        while(low >=0 && high < len && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
            count++;
        }
        return count;
    }

    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            //
            ans += checkPalindrome(s, i, i);
            ans += checkPalindrome(s, i, i+1);
        }
        return ans;
    }
}
