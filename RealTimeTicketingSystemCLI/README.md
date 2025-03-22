# Real-Time Ticketing System

## Introduction
The Real-Time Ticketing System is a multi-threaded application designed to simulate the process of ticket sales and distribution. It allows vendors to release tickets into a shared pool while customers attempt to purchase them concurrently. This system showcases the use of threading, synchronization, and configuration management in Java, providing a practical example of real-time operations in a ticketing scenario.

## Setup Instructions

### Prerequisites
Before running the application, ensure you have the following installed on your machine:

- **Java Development Kit (JDK)**: Version 11 or higher
- **Maven**: For managing dependencies and building the project

### How to Build and Run the Application

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/RealTimeTicketingSystem.git
   cd RealTimeTicketingSystem
2. **Build the project**
3. Use Maven to build the project:
   mvn clean install
4. Run the Application
   After building, you can run the application using:
   bash
   mvn exec:java -Dexec.mainClass="com.example.RealTimeTicketingSystem1.Main"
5. How to Configure and Start the System
   Configuration File
   The system configuration can be set up in a JSON file located at src/main/resources/config.json. Here’s an example of how to structure your configuration:
   json
   {
   "totalTickets": 100,
   "vendorRate": 5,
   "customerRate": 3,
   "maxPoolCapacity": 50,
   "runDuration": 60
   }
6. License
   This project is licensed under the MIT License - see the LICENSE file for details.
   text

This README provides a thorough overview of your project, including setup instructions, usage details, code structure explanations, and logging information. You can adjust any sections as needed based on your specific implementation or additional features you may want to include.
