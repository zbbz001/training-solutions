package week08d03;

import java.util.ArrayList;
import java.util.List;

public class StringLists {

    public List<String> shortestWords(List<String> words) {
        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException("The word list cannot be empty.");
        }

        List<String> shortestWords = new ArrayList<>();
        int length = findShortestLength(words);

        for (String word : words) {
            if (word.length() == length) {
                shortestWords.add(word);
            }
        }
        return shortestWords;
    }

    private int findShortestLength(List<String> words) {
        int length = words.get(0).length();
        for (String word : words) {
            if (word.length() < length) {
                length = word.length();
            }
            if (length == 1) {
                return length;
            }
        }
        return length;
    }
}
