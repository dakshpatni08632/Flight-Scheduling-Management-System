CREATE DATABASE IF NOT EXISTS flight_management;
USE flight_management;

CREATE TABLE IF NOT EXISTS flights (
    flight_no VARCHAR(20) PRIMARY KEY,
    airline VARCHAR(50),
    source_city VARCHAR(50),
    destination_city VARCHAR(50),
    flight_date DATE,
    departure_time TIME,
    arrival_time TIME,
    status VARCHAR(20)
);
