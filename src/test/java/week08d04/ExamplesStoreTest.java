package week08d04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExamplesStoreTest {

    @Test
    public void ExamplesStoreTest() {
        ExamplesStore examplesStore = new ExamplesStore();
        List<String> expected = Arrays.asList("Első feladat", "Második feladat");
        assertEquals(expected, examplesStore.getTitlesOfExamples());
    }
}