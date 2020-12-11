package week05d02;

import java.util.Arrays;
import java.util.List;

public class ChangeLetter {
    private static final List<Character> EN_VOWELS = Arrays.asList('a', 'e', 'i', 'o', 'u');
    private static final Character REPLACEMENT_CHAR = '*';

    public String changeVowels(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("The parameter cannot be an empty string or null.");
        }

        for (Character c : EN_VOWELS) {
            str = str.replace(c, REPLACEMENT_CHAR).replace(Character.toUpperCase(c), REPLACEMENT_CHAR);
        }

        return str;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }
}
