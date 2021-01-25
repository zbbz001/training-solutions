package iofilestest.library;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.Assert.*;

public class LibraryTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private Library library = new Library();

    @Test
    public void libraryTest() throws IOException {
        library.add(new Book("A. A. Milne", "Winnie-the-Pooh"),
                new Book("Edgar Rice Burroughs", "Tarzan of the Apes"),
                new Book("Douglas Adams", "The Hitchhiker's Guide to the Galaxy")
        );

        Path path = temporaryFolder.newFile().toPath();

        library.save(path);
        library.load(path);

        assertEquals(3, library.getBooks().size());
        assertEquals("Douglas Adams", library.getBooks().get(2).getAuthor());
        assertEquals("Winnie-the-Pooh", library.getBooks().get(0).getTitle());
    }

}

