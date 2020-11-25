package week05d03;

import java.util.ArrayList;
import java.util.List;

public class ListCounter {
    private static final Character INITIAL_LETTER = 'a';

    public int initialLetterCounter(List<String> words) {
        int numOfLetter = 0;

        for (String word : words) {
            if(INITIAL_LETTER.equals(word.toLowerCase().charAt(0))) {
                numOfLetter++;
            }
        }

        return numOfLetter;
    }
}
