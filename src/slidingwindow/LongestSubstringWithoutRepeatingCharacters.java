package slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * https://neetcode.io/problems/longest-substring-without-duplicates
 *
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 *
 * Input: s = "zxyzxyz"
 *
 * Output: 3
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int wS = 0, wE = 0;
        Set<Character> charSet = new HashSet<>();
        int res = 0;

        for (wE = 0; wE < s.length(); wE++) {
            while(charSet.contains(s.charAt(wE))) {
                charSet.remove(s.charAt(wS));
                wS++;
            }
            charSet.add(s.charAt(wE));
            res = Math.max(res, wE-wS+1);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("dvdf"));
    }
}
