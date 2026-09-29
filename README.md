Flight Scheduling Management System

Flight Scheduling Management System is a console-based Java application developed to manage basic flight scheduling activities. The application runs completely in the VS Code terminal and uses Core Java concepts such as OOP, collections, exception handling, file handling, streams, and multithreading.

The project is designed as a simple and practical Java mini-project that is easy to understand, run, and explain during a B.Tech practical or viva.

WHAT THE PROJECT DOES

The system provides a menu-driven interface for managing flight information. Users can:

- View all available flights
- Add new flight details
- Search flights by route
- Search for a flight by flight number
- Update flight status
- Cancel a flight
- View flight statistics
- Display a live clock
- Save and load flight data using a CSV file

PROJECT STRUCTURE

Flight Scheduling Management System

├── src/
│   └── com/flight/flights/
│       ├── Main.java
│       ├── model/
│       ├── service/
│       ├── exception/
│       ├── util/
│       ├── thread/
│       └── dao/
│
├── data/
│   └── flights.csv
├── docs/
├── screenshots/
├── run.bat
└── README.md

MAIN CLASSES

Main.java
Handles the main menu and takes input from the user through the terminal.

Flight.java
Stores important flight details such as flight number, airline, source, destination, date, time, and status.

FlightService.java
Contains the main operations such as adding, searching, updating, cancelling, and calculating flight statistics.

InternationalFlight.java
Extends the Flight class and demonstrates inheritance and method overriding.

FlightFileManager.java
Handles reading and writing flight information to the CSV file.

ClockThread.java
Displays the current time using Java multithreading.

FlightValidationException.java
Handles invalid flight information using a custom exception.

TECHNOLOGIES AND CONCEPTS USED

- Java
- Object-Oriented Programming
- Classes and Objects
- Encapsulation
- Inheritance and Polymorphism
- Abstraction
- ArrayList
- Java Streams
- Exception Handling
- File Handling
- Multithreading
- Basic JDBC

HOW TO RUN

Open the project in VS Code and open the terminal.

Compile the project:

Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { $_.FullName } > sources.txt
javac -d out @sources.txt

Run the application:

java -cp out com.flight.flights.Main

On Windows, you can also run:

.\run.bat

MAIN MENU

1. View All Flights
2. Add New Flight
3. Search Flights by Route
4. Search Flight by Number
5. Update Flight Status
6. Cancel Flight
7. Flight Statistics
8. Show Live Clock
9. Save and Exit

DATA STORAGE

The main application uses a CSV file to store flight information. This makes the project simple to run without requiring a separate database setup.

A basic JDBC class is also included to demonstrate how Java can be connected to a database.

REQUIREMENTS

- JDK 8 or newer
- VS Code or any Java IDE
- Java compiler and runtime

No GUI or MySQL setup is required to run the main application.

PURPOSE

This project demonstrates how different Core Java concepts can be combined to create a practical Flight Scheduling Management System. 
