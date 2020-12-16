package week08d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListsTest {
    StringLists stringLists = new StringLists();
    List<String> words;

    @BeforeEach
    public void init() {
        words = new ArrayList<>(List.of("aaa", "aa", "bb", "cccc", "dd"));
    }

    @Test
    public void stringListTest() {
        List<String> result = stringLists.shortestWords(words);
        List<String> expected = new ArrayList<>(List.of("aa", "bb", "dd"));

        assertTrue(expected.size() == result.size() && expected.containsAll(result) && result.containsAll(expected));
    }

    @Test
    public void stringListTestWithEmptyList() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> stringLists.shortestWords(new ArrayList<String>()));

        assertEquals("The word list cannot be empty.", e.getMessage());
    }
}