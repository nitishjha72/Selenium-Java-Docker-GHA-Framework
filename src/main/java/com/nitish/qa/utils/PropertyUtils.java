package com.nitish.qa.utils;

import com.nitish.qa.constants.FrameworkConstants;
import com.nitish.qa.enums.ConfigProperties;
import com.nitish.qa.exceptions.PropertyFileUsageException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils() {}

    private static final Map<String, String> CONFIG_MAP = new HashMap<>();

    static {
        Properties properties = new Properties();

        try (InputStream is =
                     ResourceLoader.getResourceStream(
                             FrameworkConstants.getConfigFilePath())) {

            if (is == null) {
                throw new PropertyFileUsageException("config.properties not found in the given path: " + FrameworkConstants.getConfigFilePath());
            }

            properties.load(is);

        } catch (IOException e) {
            throw new PropertyFileUsageException("Unable to load config.properties", e);
        }

        // Normalize and cache
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            CONFIG_MAP.put(
                    String.valueOf(entry.getKey()).trim().toUpperCase(),
                    String.valueOf(entry.getValue()).trim()
            );
        }
    }

    /**
     * Reads ONLY from config.properties.
     * Returns null if key is not present.
     */
    protected static String get(ConfigProperties key) {
        return CONFIG_MAP.get(key.name().toUpperCase());
    }
}

//    protected static String getValue(ConfigProperties key) {
//        String value = prop.getProperty(key.name().toLowerCase());
//        if (Objects.isNull(value)) {
//            throw new RuntimeException("Property not found: " + key);
//        }
//        return value.trim();
//    }

