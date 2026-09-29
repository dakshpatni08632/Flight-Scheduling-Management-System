package com.flight.flights.util;

import com.flight.flights.model.Flight;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FlightFileManager {

    private final Path file = Paths.get("data", "flights.csv");

    public FlightFileManager() {
        createFile();
    }

    private void createFile() {
        try {
            if (file.getParent() != null) {
                Files.createDirectories(file.getParent());
            }

            if (!Files.exists(file)) {
                Files.createFile(file);
            }
        } catch (IOException e) {
            System.out.println("Could not create data file.");
        }
    }

    public ArrayList<Flight> loadFlights() {
        ArrayList<Flight> flights = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(file)) {

            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) {
                    try {
                        flights.add(Flight.fromCSV(line));
                    } catch (Exception e) {
                        System.out.println("Skipped invalid data row.");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading flight data.");
        }

        return flights;
    }

    public void saveFlights(List<Flight> flights) {
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {

            for (Flight flight : flights) {
                writer.write(flight.toCSV());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving flight data.");
        }
    }
}
