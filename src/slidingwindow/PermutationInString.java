package slidingwindow;

import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];
        Arrays.fill(arr, Integer.MIN_VALUE);
        for (char c : s1.toCharArray()) {
            int i = c-'a';
            if(arr[i] ==  Integer.MIN_VALUE) {
                arr[i] = 0;
            } else {
                arr[i]++;
            }

        }
        int [] arr2 = Arrays.copyOf(arr, 26);
        int count2 = 0;

        int wS = 0, wE = 0;
        for (wE = 0; wE < s2.length(); wE++) {
            int i = s2.charAt(wE) -'a';
            if (arr2[s2.charAt(wE) -'a'] != Integer.MIN_VALUE) {
                wS = wE;
                // arr2 = Arrays.copyOf(arr, 26);
            }

            while (arr2[s2.charAt(wE) -'a'] != Integer.MIN_VALUE) {
                arr2[s2.charAt(wE) -'a']--;
                count2++;
                wE++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (arr2[i] != 0 || arr2[i] != Integer.MIN_VALUE) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationInString p = new PermutationInString();
        System.out.println(p.checkInclusion("abc", "lecabee"));
    }
}
