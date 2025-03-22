package com.example.RealTimeTicketingSystem1.config;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Utility class for handling JSON configuration files.
 * This class provides methods to save and load configuration settings
 * from a JSON file using the Gson library.
 */
public class JsonConfiguration {

    private static final String CONFIG_FILE = "src/main/resources/config.json";

    /**
     * Saves the given Configuration object to a JSON file.
     *
     * @param config the Configuration object to be saved.
     */
    public static void save(Configuration config) {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            Gson gson = new Gson();
            gson.toJson(config, writer);
        } catch (IOException e) {
            System.err.println("Error saving configuration to JSON: " + e.getMessage());
        }
    }

    /**
     * Loads a Configuration object from a JSON file.
     *
     * @return the loaded Configuration object, or null if an error occurs during loading.
     */
    public static Configuration load() {
        try (FileReader reader = new FileReader(CONFIG_FILE)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, Configuration.class);
        } catch (IOException e) {
            System.err.println("Error loading configuration from JSON: " + e.getMessage());
            return null;
        }
    }
}
