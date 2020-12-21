package week08d05;

import java.nio.charset.StandardCharsets;

public class TerrainScanner {
    private int maxLength = 0;
    private int sectionLength = 0;

    public void scan(byte[] scan) {
        if (new String(scan, StandardCharsets.UTF_8).equals("1")) {
            sectionLength++;
            if (sectionLength > maxLength) {
                maxLength = sectionLength;
            }
        } else {
            sectionLength = 0;
        }
    }

    public int getMaxLength() {
        return maxLength;
    }
}
