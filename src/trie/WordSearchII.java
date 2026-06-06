package trie;

import java.util.ArrayList;
import java.util.List;

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
            curr.id = true;
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

