package com.example.RealTimeTicketingSystem1;

import com.example.RealTimeTicketingSystem1.model.Customer;
import com.example.RealTimeTicketingSystem1.model.TicketPool;
import com.example.RealTimeTicketingSystem1.model.Vendor;
import com.example.RealTimeTicketingSystem1.config.Configuration;
import com.example.RealTimeTicketingSystem1.config.JsonConfiguration;
import com.example.RealTimeTicketingSystem1.config.SerializeConfiguration;
import com.example.RealTimeTicketingSystem1.config.TextConfiguration;

import java.util.Scanner;

public class RealTimeTicketingSystem1Application {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Welcome message
		System.out.println("===============================================");
		System.out.println("      Welcome to the Real-Time Ticketing System");
		System.out.println("===============================================");

		// Input configuration
		System.out.print("Please enter the system configuration parameters:\n");

		// Create a Configuration object
		Configuration configuration = new Configuration();

		System.out.print("Total number of tickets available (e.g., 100): ");
		configuration.setTotalTickets(scanner.nextInt());

		System.out.print("Ticket release rate by vendors (tickets/second): ");
		configuration.setVendorRate(scanner.nextInt());

		System.out.print("Customer ticket retrieval rate (tickets/second): ");
		configuration.setCustomerRate(scanner.nextInt());

		System.out.print("Maximum ticket capacity in the pool (e.g., 100): ");
		configuration.setMaxPoolCapacity(scanner.nextInt());

		// Optional: Set a run duration if needed; otherwise, remove this line.
		// For example, setting it to 5 seconds:
		configuration.setRunDuration(5);

		// Saving configuration to JSON and text files
		JsonConfiguration.save(configuration);
		SerializeConfiguration.save(configuration);

		System.out.println("\nConfiguration saved successfully to 'config.json' and 'config.txt'.\n");

		// Initialize TicketPool
		TicketPool ticketPool = new TicketPool(configuration.getMaxPoolCapacity());

		// Initialize TextConfiguration for running the application
		TextConfiguration textConfig = new TextConfiguration(ticketPool, configuration);

		System.out.println("===============================================");
		System.out.println("Initializing the Ticket Pool...");
		System.out.println("Starting Vendor and Customer Threads...\n");

		// Run the system with the given configuration
		textConfig.run();

		// Summary - Assuming you have methods in TicketPool for these metrics.
		System.out.println("\n===============================================");
		System.out.println("SUMMARY");
		System.out.println("===============================================");
		System.out.println("Total tickets released by all vendors: " + ticketPool.getTicketsReleased());
		System.out.println("Total tickets sold to all customers: " + ticketPool.getTicketsSold());
		System.out.println("Remaining tickets in the pool: " + ticketPool.getAvailableTickets());
		System.out.println("Maximum ticket pool size reached: " + ticketPool.getMaxCapacityReachedCount() + " times");
		System.out.println("Customers waited for tickets: " + ticketPool.getCustomerWaitCount() + " times");
		System.out.println("Vendors waited to release tickets: " + ticketPool.getVendorWaitCount() + " times");

		System.out.println("\nSystem shutting down...");
		System.out.println("===============================================");
		System.out.println("System has shut down successfully.");
		System.out.println("Thank you for using the Real-Time Ticketing System!");

		scanner.close(); // Close scanner resource.
	}
}
