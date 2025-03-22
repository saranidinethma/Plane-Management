package com.example.RealTimeTicketingSystem1.model;

/**
 * Represents a vendor in the ticketing system.
 * This class implements Runnable to allow vendors to run in their own thread,
 * releasing tickets into a shared TicketPool at a specified rate.
 */
public class Vendor implements Runnable {

    private final TicketPool ticketPool;
    private final int vendorId;
    private final int ticketReleaseRate;

    /**
     * Constructs a Vendor with the specified TicketPool, vendor ID, and ticket release rate.
     *
     * @param ticketPool the TicketPool to which the vendor will add tickets.
     * @param vendorId the unique identifier for this vendor.
     * @param ticketReleaseRate the rate at which this vendor releases tickets.
     */
    public Vendor(TicketPool ticketPool, int vendorId, int ticketReleaseRate) {
        this.ticketPool = ticketPool;
        this.vendorId = vendorId;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    /**
     * The main execution method for the vendor thread.
     * Continuously adds tickets to the TicketPool at the specified release rate
     * until interrupted.
     */
    @Override
    public void run() {
        try {
            while (true) {
                ticketPool.addTickets(ticketReleaseRate, vendorId);
                Thread.sleep(1000); // Wait for 1 second before adding more tickets
            }
        } catch (InterruptedException e) {
            System.out.println("Vendor " + vendorId + " interrupted.");
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
}
