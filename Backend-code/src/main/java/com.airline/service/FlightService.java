package com.airline.service;

import com.airline.dao.FlightDao;
import com.airline.model.Flight;

import java.util.List;

public class FlightService {

    private FlightDao flightDao = new FlightDao();

    // Method to get all available flights
    public List<Flight> getAllFlights() {
        return flightDao.getAllFlights(); // Fetches all flights from the DAO
    }

    // Method to add a new flight
    public boolean addFlight(Flight flight) {
        // Validate flight details (optional)
        if (flight.getFlightNumber() == null || flight.getSource() == null || flight.getDestination() == null) {
            return false;
        }
        return flightDao.addFlight(flight); // Delegate to DAO for flight insertion
    }
}
