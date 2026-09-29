package com.flight.flights;

import com.flight.flights.model.Flight;
import com.flight.flights.model.InternationalFlight;
import com.flight.flights.service.FlightService;
import com.flight.flights.exception.FlightValidationException;
import com.flight.flights.thread.ClockThread;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final FlightService service = new FlightService();

    public static void main(String[] args) {
        service.loadFlights();

        System.out.println("==============================================");
        System.out.println("     FLIGHT SCHEDULING MANAGEMENT SYSTEM");
        System.out.println("==============================================");
        System.out.println("      B.Tech 2nd Year Java Mini Project");
        System.out.println();

        boolean running = true;

        while (running) {
            printMenu();

            try {
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> service.displayAllFlights();
                    case 2 -> addFlight();
                    case 3 -> searchRoute();
                    case 4 -> searchFlightNumber();
                    case 5 -> updateStatus();
                    case 6 -> cancelFlight();
                    case 7 -> service.showStatistics();
                    case 8 -> showClock();
                    case 9 -> {
                        service.saveFlights();
                        running = false;
                        System.out.println("\nData saved successfully.");
                        System.out.println("Thank you for using the Flight Scheduling System.");
                    }
                    default -> System.out.println("Invalid choice. Please select 1-9.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            if (running) {
                System.out.println("\nPress ENTER to continue...");
                sc.nextLine();
            }
        }

        sc.close();
    }

    private static void printMenu() {
        System.out.println("\n--------------- MAIN MENU ----------------");
        System.out.println("1. View All Flights");
        System.out.println("2. Add New Flight");
        System.out.println("3. Search Flights by Route");
        System.out.println("4. Search Flight by Number");
        System.out.println("5. Update Flight Status");
        System.out.println("6. Cancel Flight");
        System.out.println("7. Flight Statistics");
        System.out.println("8. Show Live Clock");
        System.out.println("9. Save and Exit");
        System.out.println("------------------------------------------");
    }

    private static void addFlight() {
        try {
            System.out.println("\n========== ADD NEW FLIGHT ==========");

            System.out.print("Flight number: ");
            String number = sc.nextLine().trim();

            System.out.print("Airline: ");
            String airline = sc.nextLine().trim();

            System.out.print("Source city: ");
            String source = sc.nextLine().trim();

            System.out.print("Destination city: ");
            String destination = sc.nextLine().trim();

            System.out.print("Date (YYYY-MM-DD): ");
            String date = sc.nextLine().trim();

            System.out.print("Departure time (HH:MM): ");
            String departure = sc.nextLine().trim();

            System.out.print("Arrival time (HH:MM): ");
            String arrival = sc.nextLine().trim();

            System.out.print("Status [Scheduled/Delayed/Cancelled]: ");
            String status = sc.nextLine().trim();

            Flight flight = new Flight(
                    number, airline, source, destination,
                    date, departure, arrival, status
            );

            service.addFlight(flight);
            System.out.println("\nFlight added successfully.");

        } catch (FlightValidationException e) {
            System.out.println("\nValidation Error: " + e.getMessage());
        }
    }

    private static void searchRoute() {
        System.out.print("\nEnter source city: ");
        String source = sc.nextLine().trim();

        System.out.print("Enter destination city: ");
        String destination = sc.nextLine().trim();

        List<Flight> result = service.searchByRoute(source, destination);
        service.printFlights(result);
    }

    private static void searchFlightNumber() {
        System.out.print("\nEnter flight number: ");
        String number = sc.nextLine().trim();

        Flight flight = service.searchByNumber(number);

        if (flight == null) {
            System.out.println("Flight not found.");
        } else {
            flight.displayDetails();
        }
    }

    private static void updateStatus() {
        System.out.print("\nEnter flight number: ");
        String number = sc.nextLine().trim();

        System.out.print("Enter new status: ");
        String status = sc.nextLine().trim();

        try {
            service.updateStatus(number, status);
            System.out.println("Flight status updated successfully.");
        } catch (FlightValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private static void cancelFlight() {
        System.out.print("\nEnter flight number to cancel: ");
        String number = sc.nextLine().trim();

        try {
            service.cancelFlight(number);
            System.out.println("Flight cancelled successfully.");
        } catch (FlightValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void showClock() {
        System.out.println("\nStarting clock thread for 5 seconds...");
        ClockThread clock = new ClockThread();
        clock.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        clock.stopClock();
        System.out.println("Clock thread stopped.");
    }
}
