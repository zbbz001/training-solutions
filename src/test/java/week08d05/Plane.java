package week08d05;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

public class Plane {
    public int scanTerrain() {
        Path path = Path.of("map.txt");
        TerrainScanner terrainScanner = new TerrainScanner();

        try (InputStream inputStream = Plane.class.getResourceAsStream("map.txt")) {
            byte[] scan = new byte[1];

            int size = 0;
            while ((size = inputStream.read(scan)) > 0) {
                terrainScanner.scan(scan);
                scan = new byte[1];
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

        return terrainScanner.getMaxLength();
    }

    public static void main(String[] args) {
        Plane plane = new Plane();
        System.out.println(plane.scanTerrain());
    }


}
