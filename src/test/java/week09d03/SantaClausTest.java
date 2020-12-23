package week09d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SantaClausTest {
    @Test
    public void santaClausTest() {
        SantaClaus sc = new SantaClaus(List.of(
                new Person("Cody Coder", 10),
                new Person("John James Rambo", 9),
                new Person("Mickey Mouse", 92)));

        sc.getThroughChimneys();

        for (Person person : sc.getPersonList()) {
            if (person.getAge() < 15) {
                assertTrue(List.of(Present.values()).contains(person.getPresent()));
            } else {
                assertTrue(List.of(Present.values()).contains(person.getPresent()) && !person.getPresent().equals(Present.Toy));
            }
        }
    }

    @Test
    public void emptyPersonListTest() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new SantaClaus(new ArrayList<>());
        });

        assertEquals("The list of persons cannot be empty, so no work today", ex.getMessage());
    }
}