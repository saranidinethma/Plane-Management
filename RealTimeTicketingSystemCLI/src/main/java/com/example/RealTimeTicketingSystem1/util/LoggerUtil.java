package com.example.RealTimeTicketingSystem1.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Utility class for logging messages to a file.
 * This class configures a Logger to write log messages to a specified log file
 * and provides methods for logging messages at different levels.
 */
public class LoggerUtil {
    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());

    static {
        try {
            // Set up file handler for logging to a file
            FileHandler fileHandler = new FileHandler("src/main/resources/system.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL); // Set the logging level to ALL
            logger.setUseParentHandlers(false); // Disable console logging by default
        } catch (IOException e) {
            System.err.println("Failed to initialize logger: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        }
    }

    /**
     * Logs an informational message to the log file.
     *
     * @param message the message to be logged.
     */
    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    /**
     * Logs a message at a specified logging level.
     *
     * @param level the level at which the message should be logged (e.g., INFO, WARNING, SEVERE).
     * @param message the message to be logged.
     */
    public static void log(Level level, String message) {
        logger.log(level, message);
    }
}
