package iostringwriter.longwords;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {

    public void writeLongWords(Writer writer, List<String> words) {
        PrintWriter printWriter = new PrintWriter(writer);

        for (String word : words) {
            printWriter.print(word);
            printWriter.print(":");
            printWriter.println(word.length());
        }
    }

    public String writeWithStringWriter(List<String> words) {
        try (Writer writer = new StringWriter()) {
            writeLongWords(writer, words);

            return writer.toString();
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write");
        }
    }
}
