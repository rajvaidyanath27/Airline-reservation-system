package com.airline.controller;

import com.airline.model.Flight;
import com.airline.service.FlightService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/flights")
public class FlightController extends HttpServlet {
    private FlightService flightService = new FlightService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            // Fetch flight details
            List<Flight> flights = flightService.getAllFlights();

            // Add flights to session
            HttpSession session = req.getSession();
            session.setAttribute("flights", flights);

            // Redirect to flights page
            req.getRequestDispatcher("flights.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error: Unable to fetch flight details.");
        }
    }
}
