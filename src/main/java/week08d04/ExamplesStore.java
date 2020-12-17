package week08d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExamplesStore {
    final static String TITLE_MARKER = "# ";

    public List<String> getTitlesOfExamples() {
        List<String> titles = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                ExamplesStore.class.getResourceAsStream("examples.md")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                titles = addToList(titles, line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("File not found.");
        }

        return titles;
    }

    private List<String> addToList(List<String> titles, String line) {
        if (line.startsWith(TITLE_MARKER)) {
            titles.add(line.replace(TITLE_MARKER, ""));
        }
        return titles;
    }
}
