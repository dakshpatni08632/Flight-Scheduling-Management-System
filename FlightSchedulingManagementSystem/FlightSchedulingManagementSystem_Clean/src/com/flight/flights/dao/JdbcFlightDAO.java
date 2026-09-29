package com.flight.flights.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Optional JDBC demonstration for the syllabus.
 * The main console project uses CSV file handling so that it
 * can run in VS Code without requiring MySQL.
 */
public class JdbcFlightDAO {

    private final String url =
            "jdbc:mysql://localhost:3306/flight_management";
    private final String username = "root";
    private final String password = "root";

    public void testConnection() {

        String sql = "SELECT flight_no, airline FROM flights";

        try (Connection con =
                     DriverManager.getConnection(url, username, password);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getString("flight_no")
                                + " - "
                                + rs.getString("airline"));
            }

        } catch (Exception e) {
            System.out.println(
                    "JDBC connection error: " + e.getMessage());
        }
    }
}
