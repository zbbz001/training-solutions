package week16d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class VowelFilter {
    static final List<Character> VOWELS = List.of('a', 'á', 'e', 'é', 'i', 'í', 'o', 'ó', 'ö', 'ő', 'u', 'ú', 'ü', 'ű');

    public String filterVowels(BufferedReader reader) throws IOException {
        String line;
        StringBuilder output = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                String lcStr = line.toLowerCase();
                if (!VOWELS.contains(lcStr.charAt(i))) {
                    output.append(line.charAt(i));
                }
            }
            output.append("\n");
        }

        return output.toString();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(VowelFilter.class.getResourceAsStream("/vowelfilter.txt")))) {
            VowelFilter vowelFilter = new VowelFilter();

            System.out.println(vowelFilter.filterVowels(reader));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
