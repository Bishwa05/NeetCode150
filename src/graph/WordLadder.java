package graph;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 1;
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) return -1;

        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String word = queue.poll();

                char[] wordCharArr = word.toCharArray();
                for (int i = 0; i <wordCharArr.length; i++) {
                    char currChar = wordCharArr[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (currChar == c) continue;

                        wordCharArr[i] = c;
                        String newWord = String.valueOf(wordCharArr);

                        if (newWord.equals(endWord)) {
                            return result+1;
                        }

                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    wordCharArr[i] = currChar;
                }
                size--;
            }
            result++;
        }

        return 0;
    }
}
