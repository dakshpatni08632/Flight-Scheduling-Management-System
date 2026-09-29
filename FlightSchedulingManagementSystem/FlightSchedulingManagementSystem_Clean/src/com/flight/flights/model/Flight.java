package com.flight.flights.model;

public class Flight {
    private String flightNumber;
    private String airline;
    private String source;
    private String destination;
    private String date;
    private String departureTime;
    private String arrivalTime;
    private String status;

    public Flight(String flightNumber, String airline, String source,
                  String destination, String date, String departureTime,
                  String arrivalTime, String status) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = status;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toCSV() {
        return flightNumber + "," + airline + "," + source + "," +
                destination + "," + date + "," + departureTime + "," +
                arrivalTime + "," + status;
    }

    public static Flight fromCSV(String line) {
        String[] data = line.split(",", -1);

        return new Flight(
                data[0], data[1], data[2], data[3],
                data[4], data[5], data[6], data[7]
        );
    }

    public void displayDetails() {
        System.out.println("\n----------------------------------------");
        System.out.println("Flight Number : " + flightNumber);
        System.out.println("Airline       : " + airline);
        System.out.println("Route         : " + source + " -> " + destination);
        System.out.println("Date          : " + date);
        System.out.println("Departure     : " + departureTime);
        System.out.println("Arrival       : " + arrivalTime);
        System.out.println("Status        : " + status);
        System.out.println("----------------------------------------");
    }
}
