package trie;

/**
 * Implement Trie (Prefix Tree)
 * Medium
 * Topics
 * Company Tags
 * Hints
 * A prefix tree (also known as a trie) is a tree data structure used to efficiently store and retrieve keys in a set of strings. Some applications of this data structure include auto-complete and spell checker systems.
 *
 * Implement the PrefixTree class:
 *
 * PrefixTree() Initializes the prefix tree object.
 * void insert(String word) Inserts the string word into the prefix tree.
 * boolean search(String word) Returns true if the string word is in the prefix tree (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 * Example 1:
 *
 * Input:
 * ["Trie", "insert", "dog", "search", "dog", "search", "do", "startsWith", "do", "insert", "do", "search", "do"]
 *
 * Output:
 * [null, null, true, false, true, null, true]
 *
 */
public class PrefixTree {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isLeaf;
    }
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isLeaf = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return curr.isLeaf;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return true;
    }
}
