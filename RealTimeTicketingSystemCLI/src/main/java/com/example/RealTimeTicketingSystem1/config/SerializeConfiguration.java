package com.example.RealTimeTicketingSystem1.config;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.io.*;

/**
 * Utility class for handling serialized configuration files.
 * This class provides methods to save and load configuration settings
 * using Java's built-in serialization mechanism.
 */
public class SerializeConfiguration {

    private static final String CONFIG_FILE = "src/main/resources/config.txt";

    /**
     * Saves the given Configuration object to a serialized file.
     *
     * @param config the Configuration object to be saved.
     */
    public static void save(Configuration config) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CONFIG_FILE))) {
            oos.writeObject(config);
        } catch (IOException e) {
            System.err.println("Error saving configuration to serialized file: " + e.getMessage());
        }
    }

    /**
     * Loads a Configuration object from a serialized file.
     *
     * @return the loaded Configuration object, or null if an error occurs during loading.
     */
    public static Configuration load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CONFIG_FILE))) {
            return (Configuration) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading configuration from serialized file: " + e.getMessage());
            return null;
        }

    }
}
