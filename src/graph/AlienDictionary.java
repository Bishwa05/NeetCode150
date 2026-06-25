package graph;

import java.util.*;

/**
 *
 * There is a new alien language that uses the English alphabet, but the order of the letters is unknown.
 *
 * You are given a list of strings words from the alien language's dictionary. It is claimed that the strings in words are sorted lexicographically by the rules of this new language.
 *
 * If this claim is incorrect, and the given arrangement of strings in words cannot correspond to any order of letters, return "".
 *
 * Otherwise, return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there are multiple solutions, return any of them.
 *
 * A string a is lexicographically smaller than a string b if either of the following is true:
 *
 * The first letter where they differ is smaller in a than in b.
 * a is a prefix of b and a.length < b.length.
 *
 * Example 1:
 *
 * Input: words = ["z","o"]
 *
 * Output: "zo"
 * Explanation:
 * From "z" and "o", we know 'z' < 'o', so return "zo".
 *
 *
 * Example 2:
 *
 * Input: words = ["hrn","hrf","er","enn","rfnn"]
 *
 * Output: "hernf"
 *
 */
public class AlienDictionary {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length -1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            int minLen = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }

            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (!adj.get(w1.charAt(j)).contains(w2.charAt(j))) {
                        adj.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.put(w2.charAt(j), indegree.get(w2.charAt(j))+1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();

        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                q.offer(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()) {
            char freeChar = q.poll();
            res.append(freeChar);
            for (char neighbour : adj.get(freeChar)) {
                indegree.put(neighbour, indegree.get(neighbour) -1);
                if (indegree.get(neighbour) == 0) {
                    q.offer(neighbour);
                }
            }
        }

        if (res.length() != indegree.size()) {
            return "";
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] words = {"hrn","hrf","er","enn","rfnn"};
        AlienDictionary a = new AlienDictionary();
        System.out.println(a.foreignDictionary(words));
    }
}
