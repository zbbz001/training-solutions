package properties;

import java.io.*;
import java.nio.file.Path;
import java.util.Properties;

public class DatabaseConfiguration {
    Properties properties = new Properties();
    private static final String PROPERTIES_ENCODING = "UTF-8";

    public DatabaseConfiguration() {
        try (InputStreamReader reader = new InputStreamReader(this.getClass().getResourceAsStream("/db.properties"), PROPERTIES_ENCODING)) {
            properties.load(reader);
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file");
        }
    }

    public DatabaseConfiguration(File file) {
        try (InputStreamReader inputStream = new InputStreamReader(new FileInputStream(file), PROPERTIES_ENCODING)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file");
        }
    }

    public String getHost() {
        return properties.getProperty("db.host");
    }

    public int getPort() {
        return Integer.valueOf(properties.getProperty("db.port"));
    }

    public String getSchema() {
        return properties.getProperty("db.schema");
    }
}
