package iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Installer {

    public void install(String installPath) {
        if (!Files.exists(Path.of(installPath)) || !Files.isDirectory(Path.of(installPath))) {
            throw new IllegalArgumentException("The given directory doesn't exist");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Installer.class.getResourceAsStream("install/install.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.endsWith("/")) {
                    Files.createDirectory(Path.of(installPath + "/" + line));
                } else {
                    Files.copy(Installer.class.getResourceAsStream("install/" + line), Path.of(installPath + "/" + line));
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Install is failed", e);
        }
    }
}
