package week05d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListCounterTest {

    @Test
    public void testListCounter() {
        ListCounter listCounter = new ListCounter();
        List<String> words = new ArrayList<>();
        words.add("telephone");
        words.add("acceptable");
        words.add("Aftermath");
        words.add("cheese");
        words.add("abhorrent");

        assertEquals(3, listCounter.initialLetterCounter(words));
    }
}