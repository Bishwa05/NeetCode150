package trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2-D grid of characters board and a list of strings words,
 * return all words that are present in the grid.
 *
 * For a word to be present it must be possible to form the word with a path in the
 * board with horizontally or vertically neighboring cells. The same cell may not be used
 * more than once in a word.
 *
 * Input:
 * board = [
 *   ["a","b","c","d"],
 *   ["s","a","a","t"],
 *   ["a","c","k","e"],
 *   ["a","c","d","n"]
 * ],
 * words = ["bat","cat","back","backend","stack"]
 *
 * Output: ["cat","back","backend"]
 *
 */
class WordSearchII {


    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isLeaf;
        boolean id;
    }
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int index = c -'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isLeaf = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            insert(word);
        }

        TrieNode curr = root;
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWord(board, i, j,curr, "", result);
            }
        }
        return result;
    }

    int[][] DIRS = new int[][] {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    private void findWord(char[][] board, int i, int j, TrieNode curr, String word, List<String> result) {

        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] == '#') return;

        char c = board[i][j];
        int index = c - 'a';
        if(curr.children[index] == null) return;

        board[i][j] = '#';
        word = word + c;
        curr = curr.children[index];
        if (curr.isLeaf && !curr.id) {
            result.add(word);
            curr.id = true; // mark the node is already considered for the word.
        }

        for (int[] dir : DIRS) {
            findWord(board, i+dir[0], j+ dir[1], curr, word, result);
        }
        board[i][j] = c;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'a', 'b', 'c', 'd'},
                {'s', 'a', 'a', 't'},
                {'a', 'c', 'k', 'e'},
                {'a', 'c', 'd', 'n'}
        };

        String[] words = {"bat","cat","back","backend","stack"};

        WordSearchII w = new WordSearchII();
        w.findWords(board,words);
    }
}

