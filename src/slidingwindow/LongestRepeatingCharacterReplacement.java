package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://neetcode.io/problems/longest-repeating-substring-with-replacement
 * You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k characters of the string and replace them with any other uppercase English character.
 *
 * After performing at most k replacements, return the length of the longest substring which contains only one distinct character.
 *
 * Example 1:
 *
 * Input: s = "XYYX", k = 2
 * Output: 4
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int wS = 0, wE = 0;
        int maxLetterCount = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLen = 0;
        for (wE = 0; wE < s.length(); wE++) {
            char currChar = s.charAt(wE);
            charMap.put(currChar, charMap.getOrDefault(currChar, 0)+1);
            maxLetterCount = Math.max(maxLetterCount, charMap.get(currChar));

            if (wE - wS + 1 - maxLetterCount > k) {
                char leftChar = s.charAt(wS);
                charMap.put(leftChar, charMap.get(leftChar) - 1);
                wS++;
            }
            maxLen = Math.max(maxLen, wE - wS + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
        System.out.println(l.characterReplacement("AAABABB", 1));
    }
}
