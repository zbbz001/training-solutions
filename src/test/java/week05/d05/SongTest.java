package week05.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    @Test
    public void testSongArtist() {
        Exception ex = assertThrows(IllegalArgumentException.class, ()->new Song("Smells Like Teen Spirit", 277, ""));
        assertEquals("The song's artist cannot be empty or null.", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, ()->new Song("Smells Like Teen Spirit", 277, null));
        assertEquals("The song's artist cannot be empty or null.", ex.getMessage());
    }

    @Test
    public void testSongName() {
        Exception ex = assertThrows(IllegalArgumentException.class, ()->new Song("", 277, "Nirvana"));
        assertEquals("The song's name cannot be empty or null.", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, ()->new Song(null, 277, "Nirvana"));
        assertEquals("The song's name cannot be empty or null.", ex.getMessage());
    }

    @Test
    public void testSongLength() {
        Exception ex = assertThrows(IllegalArgumentException.class, ()->new Song("Smells Like Teen Spirit", 0, "Nirvana"));
        assertEquals("The song's length must be greater than 0, lengthInSeconds:0", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, ()->new Song("Smells Like Teen Spirit", -277, "Nirvana"));
        assertEquals("The song's length must be greater than 0, lengthInSeconds:-277", ex.getMessage());
    }
}