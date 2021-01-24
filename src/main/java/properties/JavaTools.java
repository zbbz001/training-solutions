package properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class JavaTools {
    private Properties properties = new Properties();

    public JavaTools() {
        try (InputStreamReader reader = new InputStreamReader(this.getClass().getResourceAsStream("/javatools.properties"))) {
            properties.load(reader);
        } catch (IOException e) {
            throw new IllegalStateException("File cannot open", e);
        }
    }

    public Set<String> getToolKeys() {
        Set<String> tools = new HashSet<>();
        for (String key : properties.stringPropertyNames()) {
            tools.add(key.substring(0, key.indexOf(".")));
        }

        return tools;
    }

    public Set<String> getTools() {
        Set<String> toolsName = new HashSet<>();
        for (String key : properties.stringPropertyNames()) {
            if (key.indexOf(".name") != -1) {
                toolsName.add(properties.getProperty(key));
            }
        }

        return toolsName;
    }

    public String getName(String name) {
        return properties.getProperty(name + ".name");
    }

    public String getUrl(String url) {
        return properties.getProperty(url + ".url");
    }
}
