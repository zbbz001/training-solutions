package stringbuilder;

public class PalindromeValidator {


    public boolean isPalindrome(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Text must not be null!");
        }

        word = word.trim();

        StringBuilder comparisonWord = new StringBuilder(word);

        return word.equalsIgnoreCase(comparisonWord.reverse().toString());
    }

}
