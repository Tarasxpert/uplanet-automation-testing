package configs;

import utils.ConfigReader;

import java.util.Map;
import java.util.Properties;
import java.util.function.Supplier;

abstract class BaseConfig {
    private static final Map<String, String> ENV_VARIABLES = System.getenv();
    private final String fileName;
    private Properties properties;

    BaseConfig(String fileName) {
        this.fileName = fileName;
    }
    final String getProperty(String key) {
        return getValueOrDefault(
                System.getProperty(key),
                () -> getValueOrDefault(findEnvVariable(key), () -> getPropertyFromFile(key)));
    }

    private Properties getAllProperties() {
        if (properties == null) {
            properties = ConfigReader.readConfig(fileName);
        }
        return properties;
    }

    private static String  getValueOrDefault(String value, Supplier<String> defaultValueGetter) {
        return  value == null || value.isBlank() ? defaultValueGetter.get() : value;
    }

    private String getPropertyFromFile(String key) {
        return getAllProperties().getProperty(key);
    }

    private static String findEnvVariable(String key) {
        String purifiedKey = purifyKey(key);
        return ENV_VARIABLES.entrySet().stream()
                .filter(e -> purifyKey(e.getKey()).equalsIgnoreCase(purifiedKey))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }

    private static String purifyKey(String key) {
        return key.replaceAll("[._-]", "");
    }
}
