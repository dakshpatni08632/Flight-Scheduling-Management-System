# Flight Scheduling Management System — Console Version

A second-year B.Tech-level Java mini project designed to run completely inside the VS Code terminal.

## Why this version?
The project is intentionally not a GUI project. It uses a simple numbered terminal menu, so it is easy to run, demonstrate, understand, and explain in a viva.

## Syllabus concepts covered

| Syllabus topic | Where it is used |
|---|---|
| Java basics / variables / operators | Menu and calculations |
| if-else / switch / loops | `Main.java` |
| Classes and Objects | `Flight.java` |
| Constructors | `Flight` constructor |
| Encapsulation | Private fields + getters/setters |
| Inheritance | `InternationalFlight extends Flight` |
| Polymorphism | `Flight` reference can refer to `InternationalFlight` |
| Method overriding | `displayDetails()` |
| Abstract class | `User.java` |
| Exception handling | `FlightValidationException` |
| try-catch-finally | `Main.java` input handling |
| Collections | `ArrayList<Flight>` |
| Streams | Search and statistics |
| File I/O | `FlightFileManager.java` |
| Multithreading | `ClockThread.java` |
| User-defined package | Multiple packages |
| JDBC | `JdbcFlightDAO.java` (optional demonstration) |

## Features

1. View all flights
2. Add a flight
3. Search by source/destination
4. Search by flight number
5. Update flight status
6. Cancel/delete a flight
7. Show flight statistics
8. Show today's system clock using a thread
9. Save and load data from CSV
10. Exit safely

## Run in VS Code

Open the project folder in VS Code.

### Windows PowerShell

```powershell
Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { $_.FullName } > sources.txt
javac -d out @sources.txt
java -cp out com.flight.flights.Main
```

### Linux / macOS

```bash
rm -rf out
mkdir out
javac -d out $(find src -name "*.java")
java -cp out com.flight.flights.Main
```

Or use the included scripts:

- Windows: `run.bat`
- Linux/macOS: `./run.sh`

## Data file

The program automatically uses:

```text
data/flights.csv
```

You can open this file in VS Code to show that the application is doing file handling.

## JDBC

The project includes a small `JdbcFlightDAO.java` class because JDBC is present in the syllabus. It is not required to run the basic project.

This is deliberate: the main project does not require MySQL, so a second-year student can run the project directly in VS Code without database installation.

## Suggested viva explanation

> "My project is a Flight Scheduling Management System developed as a console-based Java application. The user can view, add, search, update, cancel and analyze flights. I used OOP through classes, constructors, encapsulation, inheritance and polymorphism. I used ArrayList to store flights and Java Streams for searching and statistics. File I/O is used to permanently store the data in a CSV file. I also used a custom exception for validation and a separate thread for the live clock. JDBC code is included as an optional extension because it is part of the syllabus."

## Keep the demonstration simple

For a faculty demonstration:

1. Run the program.
2. Select `1` to show existing flights.
3. Select `2` to add a flight.
4. Select `3` to search a route.
5. Select `5` to change a status.
6. Select `7` to show statistics.
7. Select `8` to show the multithreaded clock.
8. Exit with `9`.
