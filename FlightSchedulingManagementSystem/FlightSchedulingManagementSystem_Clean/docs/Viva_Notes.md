# Viva Notes — Flight Scheduling Management System

## Project introduction

This is a console-based Java application for managing flight schedules.

## Why console based?

I made the project terminal based because it is easy to demonstrate in VS Code and focuses on the Java syllabus rather than GUI design.

## OOP concepts

### Class and object
`Flight` is a class. Each actual flight is an object of the `Flight` class.

### Constructor
The `Flight` constructor initializes flight number, airline, route, date, time and status.

### Encapsulation
Flight fields are private and are accessed through getter and setter methods.

### Inheritance
`InternationalFlight` extends `Flight`.

### Polymorphism
An object of a child class can be referred to using a parent-class reference.

### Abstraction
`User` is an abstract class included as a simple syllabus demonstration.

## Exception handling

`FlightValidationException` is a user-defined exception.

It is used when:
- flight number is invalid
- duplicate flight is entered
- date/time format is wrong
- status is invalid
- flight is not found

## Collections

`ArrayList<Flight>` stores the flight objects during program execution.

## Streams

Streams are used in:
- searching a flight
- finding a route
- counting scheduled flights
- counting delayed flights
- counting cancelled flights

## File handling

`FlightFileManager` uses:
- `BufferedReader`
- `BufferedWriter`
- `Files`
- `Path`

The data is stored in `data/flights.csv`.

## Multithreading

`ClockThread extends Thread`.

It prints the current system time once every second for five seconds.

This demonstrates the thread lifecycle and `sleep()`.

## JDBC

`JdbcFlightDAO` demonstrates:
- `Connection`
- `PreparedStatement`
- `ResultSet`
- `SQLException`

It is kept optional so the main project can run without MySQL.

## Simple faculty questions

**Q: Why did you use ArrayList?**  
A: Because the number of flights can change during execution and ArrayList provides dynamic storage.

**Q: Why use Stream API?**  
A: It makes filtering and counting the flight records simpler.

**Q: Why use a CSV file?**  
A: It gives permanent storage without making the main project dependent on MySQL.

**Q: What is inheritance in your project?**  
A: InternationalFlight extends Flight.

**Q: What is multithreading?**  
A: Running more than one flow of execution. I used a separate ClockThread to display the current time.

**Q: What happens when the program starts?**  
A: Flight data is loaded from the CSV file into an ArrayList.

**Q: What happens when the program exits?**  
A: The current ArrayList is written back to the CSV file.

## Recommended demonstration

Run:

```text
1 -> View all flights
2 -> Add a flight
3 -> Search a route
5 -> Update a status
7 -> Show statistics
8 -> Show live clock
9 -> Save and exit
```
