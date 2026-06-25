package twopointer;

/**
 * Given a string s, return true if it is a palindrome, otherwise return false.
 *
 * A palindrome is a string that reads the same forward and backward.
 * It is also case-insensitive and ignores all non-alphanumeric characters.
 *
 * Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).
 *
 * Example 1:
 *
 * Input: s = "Was it a car or a cat I saw?"
 * Output: true
 *
 * Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw",
 * which is a palindrome.
 *
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() -1;

        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } else {
                if (s.toLowerCase().charAt(l) != s.toLowerCase().charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(v.isPalindrome(s));
    }
}
