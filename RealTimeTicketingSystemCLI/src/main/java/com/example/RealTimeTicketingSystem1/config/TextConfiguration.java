package com.example.RealTimeTicketingSystem1.config;

import com.example.RealTimeTicketingSystem1.model.Customer;
import com.example.RealTimeTicketingSystem1.model.TicketPool;
import com.example.RealTimeTicketingSystem1.model.Vendor;

/**
 * Manages the configuration and execution of vendor and customer threads
 * in the real-time ticketing system. This class initializes the necessary
 * components and controls the execution duration of the ticketing process.
 */
public class TextConfiguration {

    private final TicketPool ticketPool;
    private final Configuration configuration;

    /**
     * Constructs a TextConfiguration with the specified TicketPool and Configuration.
     *
     * @param ticketPool the TicketPool to be used by vendors and customers.
     * @param configuration the Configuration object containing system parameters.
     */
    public TextConfiguration(TicketPool ticketPool, Configuration configuration) {
        this.ticketPool = ticketPool;
        this.configuration = configuration;
    }

    /**
     * Initializes and starts vendor and customer threads based on the configuration settings.
     * The system will run for a duration specified in the Configuration object,
     * after which all threads will be interrupted.
     */
    public void run() {
        // Initialize Vendor and Customer Threads
        Thread vendor1 = new Thread(new Vendor(ticketPool, 1, configuration.getVendorRate()));
        Thread vendor2 = new Thread(new Vendor(ticketPool, 2, configuration.getVendorRate()));
        Thread customer1 = new Thread(new Customer(ticketPool, 1, configuration.getCustomerRate()));
        Thread customer2 = new Thread(new Customer(ticketPool, 2, configuration.getCustomerRate()));
        Thread customer3 = new Thread(new Customer(ticketPool, 3, configuration.getCustomerRate()));

        // Start all threads
        vendor1.start();
        vendor2.start();
        customer1.start();
        customer2.start();
        customer3.start();

        // Let the system run for the configured duration
        try {
            Thread.sleep(configuration.getRunDuration());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }

        // Interrupt all threads
        System.out.println("\nStopping all threads...");
        vendor1.interrupt();
        vendor2.interrupt();
        customer1.interrupt();
        customer2.interrupt();
        customer3.interrupt();

        // Display summary if needed
    }
}
