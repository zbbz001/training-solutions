package week13d04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateEngine {

    public static void main(String[] args) {
        Path path = Path.of("template.txt");
        Map<String, Object> replaceMap = Map.of(
                "nev", "Cody Coder",
                "datum", LocalDate.of(2021, 01, 11),
                "osszeg", 3233.32,
                "hatarido", LocalDate.of(2021, 01, 31)
        );

        StringWriter sw = new StringWriter();

        try (BufferedWriter writer = new BufferedWriter(sw);
             BufferedReader reader = Files.newBufferedReader(path)) {

            new TemplateEngine().merge(reader, replaceMap, writer);


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sw.toString());
    }

    public void merge(BufferedReader reader, Map<String, Object> replaceMap, BufferedWriter writer) throws IOException {
        String line;

        while ((line = reader.readLine()) != null) {
            String newLine = replace(replaceMap, line);
            writer.write(newLine);
            writer.write("\n");
        }
    }

    private String replace(Map<String, Object> replaceMap, String line) {
        Pattern pattern = Pattern.compile("(\\{)([a-zA-Z0-9 ]*)(})");
        Matcher matcher = pattern.matcher(line);
        String newLine = line;

        while (matcher.find()) {
            String key = matcher.group(2);
            Object o = replaceMap.get(key);
            if (o != null) {
                String replacement;
                if (o instanceof LocalDate) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd.");
                    replacement = formatter.format((LocalDate) o);
                } else if (o instanceof Double) {
                    NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("hu", "HU"));
                    replacement = formatter.format(o);
                } else {
                    replacement = o.toString();
                }

                newLine = line.replace(matcher.group(1) + key + matcher.group(3), replacement);
            }
        }

        return newLine;
    }
}
