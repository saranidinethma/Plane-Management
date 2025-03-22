//package com.example.RealTimeTicketingSystem1.util;
//
//import java.io.IOException;
//import java.io.FileHandler;
//import java.io.SimpleFormatter;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class LoggerUtil {
//    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());
//
//    static {
//        try {
//            // Set up file handler for logging to a file
//            FileHandler fileHandler = new FileHandler("src/main/resources/system.log", true);
//            fileHandler.setFormatter(new SimpleFormatter());
//            logger.addHandler(fileHandler);
//            logger.setLevel(Level.ALL); // Set the logging level
//            logger.setUseParentHandlers(false); // Disable console logging by default
//        } catch (IOException e) {
//            System.err.println("Failed to initialize logger: " + e.getMessage());
//            e.printStackTrace(); // Print stack trace for debugging
//        }
//    }
//
//    public static void log(String message) {
//        String logMessage = String.format("%s - %s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), message);
//
//        // Log to console
//        System.out.println(logMessage);
//
//        // Log to file
//        logger.info(logMessage);
//    }
//
//    public static void log(Level level, String message) {
//        String logMessage = String.format("%s - %s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), message);
//
//        logger.log(level, logMessage);
//    }
//}