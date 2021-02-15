package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {
    public String createHistogram(BufferedReader reader) throws IOException {
        String line;
        StringBuilder output = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            output.append("*".repeat(Integer.parseInt(line)));
            output.append("\n");
        }

        return output.toString();
    }

}
