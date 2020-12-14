package iodatastream.statistics;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HeightStatistics {

    public void saveHeights(List<Integer> heights, Path path) {

        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            dataOutputStream.writeInt(heights.size());
            for (Integer height : heights) {
                dataOutputStream.writeInt(height);
            }

        } catch (IOException e) {
            throw new IllegalStateException("The file cannot write.", e);
        }
    }
}
