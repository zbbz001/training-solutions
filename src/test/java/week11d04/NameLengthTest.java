package week11d04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameLengthTest {

    @Test
    public void nameLengthTest() {
        NameLength nl = new NameLength();

        assertEquals(List.of(3, 4), nl.getLengths(List.of("Joe", "Jack", "Jane", "Jake", "George", "William")));
    }

}