package com.flight.flights.service;

import com.flight.flights.exception.FlightValidationException;
import com.flight.flights.model.Flight;
import com.flight.flights.util.FlightFileManager;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    private final ArrayList<Flight> flights = new ArrayList<>();
    private final FlightFileManager fileManager = new FlightFileManager();

    public void loadFlights() {
        flights.clear();
        flights.addAll(fileManager.loadFlights());
    }

    public void saveFlights() {
        fileManager.saveFlights(flights);
    }

    public void addFlight(Flight flight) throws FlightValidationException {
        validateFlight(flight);

        boolean exists = flights.stream()
                .anyMatch(f -> f.getFlightNumber()
                        .equalsIgnoreCase(flight.getFlightNumber()));

        if (exists) {
            throw new FlightValidationException(
                    "Flight number already exists.");
        }

        flights.add(flight);
        saveFlights();
    }

    private void validateFlight(Flight flight)
            throws FlightValidationException {

        if (flight.getFlightNumber().isBlank()
                || flight.getAirline().isBlank()
                || flight.getSource().isBlank()
                || flight.getDestination().isBlank()) {
            throw new FlightValidationException(
                    "Flight number, airline, source and destination are required.");
        }

        if (flight.getSource().equalsIgnoreCase(flight.getDestination())) {
            throw new FlightValidationException(
                    "Source and destination cannot be the same.");
        }

        if (!flight.getFlightNumber().matches("[A-Za-z0-9-]{2,10}")) {
            throw new FlightValidationException(
                    "Invalid flight number. Example: AI101 or 6E202.");
        }

        try {
            LocalDate.parse(flight.getDate());
            LocalTime.parse(flight.getDepartureTime());
            LocalTime.parse(flight.getArrivalTime());
        } catch (Exception e) {
            throw new FlightValidationException(
                    "Invalid date/time. Use YYYY-MM-DD and HH:MM.");
        }

        String status = flight.getStatus();
        if (!(status.equalsIgnoreCase("Scheduled")
                || status.equalsIgnoreCase("Delayed")
                || status.equalsIgnoreCase("Cancelled"))) {
            throw new FlightValidationException(
                    "Status must be Scheduled, Delayed or Cancelled.");
        }
    }

    public void displayAllFlights() {
        if (flights.isEmpty()) {
            System.out.println("\nNo flights available.");
            return;
        }

        printFlights(flights);
    }

    public List<Flight> searchByRoute(String source, String destination) {
        return flights.stream()
                .filter(f -> f.getSource().equalsIgnoreCase(source)
                        && f.getDestination().equalsIgnoreCase(destination))
                .collect(Collectors.toList());
    }

    public Flight searchByNumber(String number) {
        return flights.stream()
                .filter(f -> f.getFlightNumber()
                        .equalsIgnoreCase(number))
                .findFirst()
                .orElse(null);
    }

    public void updateStatus(String number, String newStatus)
            throws FlightValidationException {

        Flight flight = searchByNumber(number);

        if (flight == null) {
            throw new FlightValidationException("Flight not found.");
        }

        if (!(newStatus.equalsIgnoreCase("Scheduled")
                || newStatus.equalsIgnoreCase("Delayed")
                || newStatus.equalsIgnoreCase("Cancelled"))) {
            throw new FlightValidationException(
                    "Invalid status.");
        }

        flight.setStatus(newStatus);
        saveFlights();
    }

    public void cancelFlight(String number)
            throws FlightValidationException {

        Flight flight = searchByNumber(number);

        if (flight == null) {
            throw new FlightValidationException("Flight not found.");
        }

        flight.setStatus("Cancelled");
        saveFlights();
    }

    public void showStatistics() {
        long total = flights.size();

        long scheduled = flights.stream()
                .filter(f -> f.getStatus().equalsIgnoreCase("Scheduled"))
                .count();

        long delayed = flights.stream()
                .filter(f -> f.getStatus().equalsIgnoreCase("Delayed"))
                .count();

        long cancelled = flights.stream()
                .filter(f -> f.getStatus().equalsIgnoreCase("Cancelled"))
                .count();

        System.out.println("\n========== FLIGHT STATISTICS ==========");
        System.out.println("Total Flights : " + total);
        System.out.println("Scheduled     : " + scheduled);
        System.out.println("Delayed       : " + delayed);
        System.out.println("Cancelled     : " + cancelled);
        System.out.println("=======================================");
    }

    public void printFlights(List<Flight> list) {
        if (list.isEmpty()) {
            System.out.println("\nNo matching flights found.");
            return;
        }

        System.out.println("\n------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-15s %-15s %-12s %-10s %-10s%n",
                "Flight", "Airline", "From", "To",
                "Date", "Departure", "Status");
        System.out.println("------------------------------------------------------------------------------------------------");

        for (Flight f : list) {
            System.out.printf("%-10s %-15s %-15s %-15s %-12s %-10s %-10s%n",
                    f.getFlightNumber(),
                    f.getAirline(),
                    f.getSource(),
                    f.getDestination(),
                    f.getDate(),
                    f.getDepartureTime(),
                    f.getStatus());
        }

        System.out.println("------------------------------------------------------------------------------------------------");
    }
}
