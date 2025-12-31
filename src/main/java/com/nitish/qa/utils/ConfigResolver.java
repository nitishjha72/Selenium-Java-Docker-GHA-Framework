package com.nitish.qa.utils;

import com.nitish.qa.enums.ConfigProperties;
import com.nitish.qa.exceptions.InvalidConfigurationException;

import java.util.Locale;

public final class ConfigResolver {

    private ConfigResolver() {}

    /* Raw string access (NO formatting) */
    public static String get(ConfigProperties key) {
        return get(key, null);
    }

    public static String get(ConfigProperties key, String defaultValue) {

        String value = resolveRawValue(key);

        if (isPresent(value)) {
            return value.trim();
        }

        if (isPresent(defaultValue)) {
            return defaultValue.trim();
        }

        throw new InvalidConfigurationException(
                "Configuration value not found for key: " + key.name());
    }

    /* Enum-safe access (normalization applied here only) */
    public static <E extends Enum<E>> E getEnum(ConfigProperties key, Class<E> enumClass, E defaultValue) {

        String value = resolveRawValue(key);

        if (!isPresent(value) && defaultValue != null) {
            return defaultValue;
        }

        if (!isPresent(value)) {
            throw new InvalidConfigurationException(
                    "Configuration value not found for key: " + key.name());
        }

        try {
            return Enum.valueOf(enumClass, value.trim().toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException ex) {
            throw new InvalidConfigurationException("Invalid value '" + value + "' for enum " + enumClass.getSimpleName(), ex);
        }
    }

    private static String resolveRawValue(ConfigProperties key) {

        String value = getEnvIgnoreCase(key.name());
        if (isPresent(value)) {
            return value;
        }

        value = getSystemPropertyIgnoreCase(key.name());
        if (isPresent(value)) {
            return value;
        }

        return PropertyUtils.get(key);
    }

    private static boolean isPresent(String value) {
        return value != null && !value.isBlank();
    }

    private static String getEnvIgnoreCase(String key) {
        return System.getenv().entrySet().stream()
                .filter(e -> e.getKey().equalsIgnoreCase(key))
                .map(e -> e.getValue())
                .findFirst()
                .orElse(null);
    }

    private static String getSystemPropertyIgnoreCase(String key) {
        return System.getProperties().entrySet().stream()
                .filter(e -> e.getKey().toString().equalsIgnoreCase(key))
                .map(e -> e.getValue().toString())
                .findFirst()
                .orElse(null);
    }
}
