package com.flight.flights.model;

public class InternationalFlight extends Flight {

    private String country;

    public InternationalFlight(String flightNumber, String airline,
                               String source, String destination,
                               String date, String departureTime,
                               String arrivalTime, String status,
                               String country) {
        super(flightNumber, airline, source, destination, date,
                departureTime, arrivalTime, status);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("International Country: " + country);
    }
}
