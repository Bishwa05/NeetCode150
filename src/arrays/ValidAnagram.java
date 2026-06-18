package arrays;

/**
 *
 * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
 *
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 *
 * Example 1:
 *
 * Input: s = "racecar", t = "carrace"
 *
 * Output: true
 *
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];

        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) -'a']++;
            arr[t.charAt(i) -'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }
}
