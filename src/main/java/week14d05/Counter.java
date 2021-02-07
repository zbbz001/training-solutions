package week14d05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class Counter {

    private static boolean wordFilter(String line) {
        return line.contains("Hachi");
    }

    private static Stream<? extends String> splitLine(String line) {
        return Arrays.stream(line.split(" "));
    }

    public long read(Stream<String> stream) {
        return stream.filter(Counter::wordFilter)
                .flatMap(Counter::splitLine)
                .filter(Counter::wordFilter)
                .count();
    }

    public static void main(String[] args) {

        Counter counter = new Counter();

        try (Stream<String> stream = Files.lines(Path.of("hachiko.srt"))) {
            System.out.println(counter.read(stream));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
