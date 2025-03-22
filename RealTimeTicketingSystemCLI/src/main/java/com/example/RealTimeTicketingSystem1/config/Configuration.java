package com.example.RealTimeTicketingSystem1.config;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents the configuration settings for the real-time ticketing system.
 * This class holds parameters such as total tickets, vendor and customer rates,
 * maximum pool capacity, and the duration for which the system will run.
 */
public class Configuration implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; // For serialization

    private int totalTickets;
    private int vendorRate;
    private int customerRate;
    private int maxPoolCapacity;
    private int runDuration;

    // Getters

    /**
     * Retrieves the total number of tickets configured for the system.
     *
     * @return the total number of tickets.
     */
    public int getTotalTickets() {
        return totalTickets;
    }

    /**
     * Retrieves the rate at which vendors release tickets.
     *
     * @return the vendor release rate in tickets per second.
     */
    public int getVendorRate() {
        return vendorRate;
    }

    /**
     * Retrieves the rate at which customers attempt to retrieve tickets.
     *
     * @return the customer retrieval rate in tickets per second.
     */
    public int getCustomerRate() {
        return customerRate;
    }

    /**
     * Retrieves the maximum capacity of the ticket pool.
     *
     * @return the maximum number of tickets that can be held in the pool.
     */
    public int getMaxPoolCapacity() {
        return maxPoolCapacity;
    }

    /**
     * Retrieves the duration for which the system will run, converted to milliseconds.
     *
     * @return the run duration in milliseconds.
     */
    public int getRunDuration() {
        return runDuration * 1000; // Convert to milliseconds
    }

    // Setters

    /**
     * Sets the total number of tickets configured for the system.
     *
     * @param totalTickets the total number of tickets to set.
     */
    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    /**
     * Sets the rate at which vendors will release tickets.
     *
     * @param vendorRate the vendor release rate in tickets per second to set.
     */
    public void setVendorRate(int vendorRate) {
        this.vendorRate = vendorRate;
    }

    /**
     * Sets the rate at which customers will attempt to retrieve tickets.
     *
     * @param customerRate the customer retrieval rate in tickets per second to set.
     */
    public void setCustomerRate(int customerRate) {
        this.customerRate = customerRate;
    }

    /**
     * Sets the maximum capacity of the ticket pool.
     *
     * @param maxPoolCapacity the maximum number of tickets that can be held in the pool to set.
     */
    public void setMaxPoolCapacity(int maxPoolCapacity) {
        this.maxPoolCapacity = maxPoolCapacity;
    }

    /**
     * Sets the duration for which the system will run, in seconds.
     *
     * @param runDuration the duration in seconds to set.
     */
    public void setRunDuration(int runDuration) {
        this.runDuration = runDuration;
    }
}
