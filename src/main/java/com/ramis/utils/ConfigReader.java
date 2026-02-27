package com.ramis.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Configuration Reader Utility
 * Loads config.properties from the classpath (src/test/resources/).
 * Using classpath loading instead of a file-path avoids working-directory
 * issues when the JVM is launched from a different drive or directory.
 * Author: Ramis Ali (22f-3703)
 * Class: BSSE-8B
 */
public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        // Maven copies src/test/resources/config.properties → target/test-classes/
        // Loading via classpath works regardless of user.dir or drive letter.
        InputStream stream = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties");

        if (stream == null) {
            throw new RuntimeException(
                "config.properties not found on classpath. " +
                "Ensure src/test/resources/config.properties exists and is on the test classpath.");
        }

        try {
            properties.load(stream);
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage(), e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
