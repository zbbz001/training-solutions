package iofiletest.cheeseManager;

import iofiletest.library.Library;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CheeseManagerTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    private CheeseManager cm = new CheeseManager();

    @Test
    public void cheeseManagetTest() throws IOException {
        Path path = temporaryFolder.newFile().toPath();

        List<Cheese> cheeseList = new ArrayList<>();
        cheeseList.add(new Cheese("Camembert", 1.5));
        cheeseList.add(new Cheese("Brie", 2));
        cheeseList.add(new Cheese("Cheddar", 2.1));

        cm.saveToFile(path, cheeseList);
        Cheese cheese = cm.findCheese(path, "Brie");

        assertEquals("Brie", cheese.getName());
        assertEquals(2.0, cheese.getLactose(), 0.0001);
    }
}