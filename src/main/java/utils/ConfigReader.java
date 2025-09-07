package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties props;

    public static Properties getProps() {
        if (props == null) {
            props = new Properties();
            try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
                props.load(fis);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load config.properties", e);
            }
        }
        return props;
    }

    public static String get(String key) {
        return getProps().getProperty(key);
    }
}
