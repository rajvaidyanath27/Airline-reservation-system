package com.airline.dao;

import com.airline.model.Flight;
import com.airline.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FlightDao {

    // Method to fetch all flights
    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT * FROM flights";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setId(resultSet.getInt("id"));
                flight.setFlightNumber(resultSet.getString("flight_number"));
                flight.setSource(resultSet.getString("source"));
                flight.setDestination(resultSet.getString("destination"));
                flight.setDepartureTime(resultSet.getString("departure_time"));
                flight.setArrivalTime(resultSet.getString("arrival_time"));
                flight.setPrice(resultSet.getDouble("price"));

                flights.add(flight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }

    // Method to add a flight (if needed)
    public boolean addFlight(Flight flight) {
        String query = "INSERT INTO flights (flight_number, source, destination, departure_time, arrival_time, price) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, flight.getFlightNumber());
            preparedStatement.setString(2, flight.getSource());
            preparedStatement.setString(3, flight.getDestination());
            preparedStatement.setString(4, flight.getDepartureTime());
            preparedStatement.setString(5, flight.getArrivalTime());
            preparedStatement.setDouble(6, flight.getPrice());

            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
