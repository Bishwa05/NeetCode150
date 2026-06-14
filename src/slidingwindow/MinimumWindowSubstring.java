package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t, return the shortest substring of s such that every character in t, including duplicates, is present in the substring. If such a substring does not exist, return an empty string "".

You may assume that the correct output is always unique.

Example 1:

Input: s = "OUZODYXAZV", t = "XYZ"

Output: "YXAZ"
Explanation: "YXAZ" is the shortest substring that includes "X", "Y", and "Z" from string t.

 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> charMap = new HashMap<>();
        if (t.length() > s.length()) return "";

        for (char c : t.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0)+1);
        }

        int wS = 0, wE = 0;
        int minLength = s.length()+1, subStrStart = 0;
        int matched = 0;
        for (wE = 0; wE < s.length(); wE++) {
            char rChar = s.charAt(wE);
            if (charMap.containsKey(rChar)) {
                charMap.put(rChar, charMap.getOrDefault(rChar, 0) - 1);
                if (charMap.get(rChar) >= 0) matched++;
            }

            while (matched == t.length()) {
                if (minLength > wE - wS +1) {
                    minLength = wE - wS + 1;
                    subStrStart = wS;
                }

                char lChar = s.charAt(wS++);

                if (charMap.containsKey(lChar)) {
                    if (charMap.get(lChar) == 0) matched--;
                    charMap.put(lChar, charMap.getOrDefault(lChar, 0) + 1);
                }
            }
        }

        return minLength > s.length()? "" : s.substring(subStrStart, subStrStart+minLength);
    }

    public static void main(String[] args) {

        // String s = "OUZODYXAZV", t = "XYZ";
        String s = "xyz", t = "xyz";
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        System.out.println(m.minWindow(s, t));
    }
}
