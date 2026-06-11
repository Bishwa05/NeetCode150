package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * https://neetcode.io/problems/combinations-of-a-phone-number
 *
 * You are given a string digits made up of digits from 2 through 9 inclusive.
 *
 * Each digit (not including 1) is mapped to a set of characters as shown below:
 *
 * A digit could represent any one of the characters it maps to.
 *
 * Return all possible letter combinations that digits could represent. You may return the answer in any order.
 *
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> digitMap = Map.of('2', "abc",
                '3', "def", '4', "ghi", '5', "jkl", '6', "mno",
                '7', "pqrs", '8', "tuv", '9', "wxyz");

        List<String> res = new ArrayList<>();

        if (digits.isEmpty()) return res;

        dfs(digits, "",digitMap, res);
        return res;
    }

    private void dfs(String digits, String s, Map<Character, String> digitMap, List<String> res) {
        if (digits.length() == 0) {
            res.add(s);
            return;
        }

        char c = digits.charAt(0);
        String str1 = digitMap.get(c);
        for (char c1 : str1.toCharArray()) {
            dfs(digits.substring(1), s+c1, digitMap, res);
        }
    }

    // Another way

//    StringBuilder path = new StringBuilder();
//    backtracking(path, digits, 0, map );
//        return result;

//    public void backtracking(StringBuilder path, String digits, int index,Map<Character, String> map){
//        if(path.length() == digits.length()){
//            res.add(path.toString());
//            return;
//        }
//        String s = map.get(digits.charAt(index));
//        for(int i = 0; i < s.length(); i++){
//            path.append(s.charAt(i));
//            backtracking(path, digits, index + 1, map);
//            path.deleteCharAt(path.length() - 1);
//        }
//
//    }
}
