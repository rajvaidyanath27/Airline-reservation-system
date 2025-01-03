package com.airline.service;

import com.airline.dao.FlightDao;
import com.airline.model.Flight;

import java.util.List;

public class FlightService {

    private FlightDao flightDao = new FlightDao();

    // Method to get all available flights
    public List<Flight> getAllFlights() {
        return flightDao.getAllFlights();
    }

    // Method to add a new flight (optional, if needed)
    public boolean addFlight(Flight flight) {
        return flightDao.addFlight(flight);
    }
}

