package week11d03;

import java.util.*;

public class CharCounter {
    private Set<Character> characterList = null;

    public int countChars(String[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (characterList != null) {
                makeCharList(toList(chars[i]));
            } else {
                characterList = toList(chars[i]);
            }
        }

        return characterList.size();
    }

    private Set<Character> toList(String str) {
        Set<Character> chars = new TreeSet<>();
        for (char ch : str.toCharArray()) {
            chars.add(ch);
        }

        return chars;
    }

    private void makeCharList(Set<Character> chars) {
        Set<Character> characters = new TreeSet<>(characterList);

        for (Character c : characters) {
            if (!chars.contains(c)) {
                characterList.remove(c);
            }
        }
    }
}
