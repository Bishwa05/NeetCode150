package slidingwindow;

/**
 * You are given two strings s1 and s2.
 *
 * Return true if s2 contains a permutation of s1, or false otherwise.
 * That means if a permutation of s1 exists as a substring of s2, then return true.
 *
 * Both strings only contain lowercase letters.
 *
 * Example 1:
 * Input: s1 = "abc", s2 = "lecabee"
 *
 * Output: true
 * Explanation: The substring "cab" is a permutation of "abc" and is present in "lecabee".
 *
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) matches++;
        }

        int wS = 0;

        for (int wE = s1.length(); wE < s2.length(); wE++) {
            if (matches == 26) return true;

            int index = s2.charAt(wE) -'a';
            s2Count[index]++;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] + 1 == s2Count[index]) {
                matches--;
            }

            index = s2.charAt(wS) - 'a';
            s2Count[index]--;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] - 1 == s2Count[index]) {
                matches--;
            }
            wS++;
        }
        return matches == 26;
    }

    public static void main(String[] args) {
        PermutationInString p = new PermutationInString();
        System.out.println(p.checkInclusion("abc", "lecabee"));
    }
}
