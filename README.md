# Flight Scheduling Management System

Flight Scheduling Management System is a desktop application built in Java that handles the everyday tasks involved in running a small airline's ground operations — passengers, flights, and bookings. It's built with Java Swing and AWT for the interface, and it talks to a MySQL database in the background.

This was put together mainly as a learning project, to get hands-on practice with Java GUI programming, JDBC, and how a desktop app ties into a real database.

## What the Project Does

Once a user signs in, they get access to a handful of modules that cover the core airline workflow. Broadly, the system lets you:

- Log in with a username and password
- Add and manage passenger records
- Add and browse flight information
- Book tickets for passengers
- Edit or update existing booking details
- Cancel a booking when needed
- Store and retrieve all of this through a database
- Do all of the above through a plain desktop GUI

## How the Code is Organized

The application is split across several Java classes, each handling one piece of the workflow:

```text
Flight Scheduling Management System

├── Login.java
├── Passenger Details
├── Flight Information
├── Ticket Booking
├── Cancellation
├── Update Details
├── Database / JDBC Classes
└── Other Utility Classes
```

### What Each Class Does

**Login.java**
Displays the login screen and takes care of basic authentication before letting a user in.

**Passenger Details**
Handles adding, viewing, and editing passenger records.

**Flight Information**
Lets a user add new flights or look up the ones already in the system.

**Ticket Booking**
Walks through the process of booking a ticket, linking a passenger to a flight.

**Cancellation / Update**
Used when a booking needs to be cancelled, or when passenger/ticket information needs correcting.

**Database Classes**
The layer that actually talks to MySQL — inserting, updating, deleting, and fetching records as needed.

## Tech Stack

- Java
- Swing
- AWT
- JDBC
- MySQL
- JCalendar
- Any Java IDE — NetBeans, IntelliJ IDEA, or Eclipse

Runs fine on JDK 8 and anything newer.

## Feature Breakdown

### 1. Login
A simple sign-in screen gates access to the rest of the app.

### 2. Passenger Module
Covers adding, viewing, and updating passenger information.

### 3. Flight Module
Lets you record new flights and check what's already listed.

### 4. Booking
Combines passenger and flight details to create a new reservation.

### 5. Cancellation
Reverses a booking that was made earlier.

### 6. Updates
For correcting passenger or ticket details after the fact.

### 7. Desktop Interface
Built with standard Swing/AWT components — frames, panels, text fields, buttons, tables — nothing fancy, just functional.

## Database Setup

MySQL needs to be installed and running for this to work, since the app relies on JDBC to connect and exchange data with it.

Before launching the app, double check that:

1. MySQL is up and running.
2. The database has been created.
3. All the necessary tables exist.
4. The username/password in the connection code actually match your MySQL setup.
5. The JDBC driver jar is included in the project.

## Getting It Running

### Step 1 — Grab the Project
Download the source (or clone it) and unzip if it came as an archive.

### Step 2 — Open It in an IDE
Load the project into NetBeans, IntelliJ IDEA, or Eclipse — whichever you prefer. If it was originally set up as a NetBeans project, NetBeans will probably give you the smoothest experience.

### Step 3 — Check Your JDK
Confirm JDK 8 or later is installed and pointed to correctly in your IDE.

### Step 4 — Set Up the Database
Create the database and required tables in MySQL, then go into the code and update the connection details (URL, username, password) to match.

### Step 5 — Bring In the Libraries
Make sure every required `.jar` is attached to the project — for instance, the JCalendar jar if the app uses a calendar picker anywhere.

### Step 6 — Launch It
Run the entry point:

```text
Login.java
```

The login window should pop up, and from there you can navigate through the rest of the app's modules.

## What You'll Need

- JDK 8 or newer
- An IDE — NetBeans, IntelliJ IDEA, or Eclipse
- MySQL (needed for the database-backed features)
- MySQL JDBC driver
- JCalendar library, if the project depends on it

## Troubleshooting

### JCalendar-related errors
Usually means the JCalendar `.jar` isn't attached to the project's libraries — go add it if it's missing.

### ClassNotFoundException
Typically points to a missing or misconfigured library. Things to try:

- Look through the project's library list
- Add whichever `.jar` is missing
- Clean and rebuild the project
- Restart the IDE if the problem persists

### Can't Connect to the Database
Run through this checklist:

- Is MySQL actually running?
- Is the database name correct?
- Are the username and password right?
- Is the JDBC driver present?
- Is the port number correct?

## Where This Could Go Next

A few directions this project could grow in if someone wanted to take it further:

- Proper login security with user roles
- Searching for flights online
- Nicer, more detailed ticket generation
- Email confirmations after booking
- Payment gateway integration
- Tighter database security
- A more polished UI
- An admin dashboard
- Search/filter tools for flights and passengers

## Why This Project Exists

This is first and foremost a learning exercise — a way to get comfortable with Java GUI development, OOP concepts, JDBC, and the general shape of a desktop management application.

## License

Built for learning purposes. Feel free to modify it, extend it, or use it as a base for your own version.

## Contributing

Suggestions and improvements are always welcome — feel free to tweak existing modules or bolt on new ones if you'd like to contribute.
