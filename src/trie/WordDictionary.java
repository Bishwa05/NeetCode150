package trie;

/**
 *
 * Design Add and Search Word Data Structure
 * Medium
 * Topics
 * Company Tags
 * Hints
 * Design a data structure that supports adding new words and searching for existing words.
 *
 * Implement the WordDictionary class:
 *
 * void addWord(word) Adds word to the data structure.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 * Example 1:
 *
 * Input:
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["day"],["bay"],["may"],["say"],["day"],[".ay"],["b.."]]
 *
 * Output:
 * [null, null, null, null, false, true, true, true]
 *
 * Explanation:
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("day");
 * wordDictionary.addWord("bay");
 * wordDictionary.addWord("may");
 * wordDictionary.search("say"); // return false
 * wordDictionary.search("day"); // return true
 * wordDictionary.search(".ay"); // return true
 * wordDictionary.search("b.."); // return true
 *
 */
public class WordDictionary {
    TrieNode root;
    class TrieNode {
        TrieNode[] children;
        boolean isLeaf;
        TrieNode() {
            children = new TrieNode[26];
        }
    }

    public WordDictionary() {

    }

    public void addWord(String word) {
        if (root == null) {
            root = new TrieNode();
        }
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isLeaf = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int pos, TrieNode node) {
        if (node == null) return false;
        if (pos == word.length()) return node.isLeaf;

        char c = word.charAt(pos);

        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, pos+1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int index = c - 'a';
            return dfs(word, pos+1, node.children[index]);
        }
    }
}

