package com.wipro;

import java.util.ArrayList;
import java.util.List;

import com.wipro.model.DomesticFlight;
import com.wipro.model.Fare;
import com.wipro.model.Flight;
import com.wipro.model.InternationalFlight;
import com.wipro.model.Passenger;
import com.wipro.model.Ticket;
import com.wipro.service.BookingService;
import com.wipro.service.FlightSearchService;

public class Main {
	public static void main(String[] args) {
		// Sample data for flights
		Flight domesticFlight1 = new DomesticFlight("DL123", "HYD", "CCU", "10:00", "14:00", new Fare(120.00, "INR"),
				150);
		Flight domesticFlight2 = new DomesticFlight("UA456", "DEL", "BOM", "12:00", "14:30", new Fare(180.00, "INR"),
				2);
		Flight internationalFlight1 = new InternationalFlight("BA789", "TRV", "COK", "15:00", "07:00",
				new Fare(220.00, "INR"), 200);
		Flight internationalFlight2 = new InternationalFlight("AF101", "VTC", "GAU", "14:00", "06:30",
				new Fare(320.00, "INR"), 180);

		// List of available flights
		List<Flight> flights = new ArrayList<>();
		flights.add(domesticFlight1);
		flights.add(domesticFlight2);
		flights.add(internationalFlight1);
		flights.add(internationalFlight2);

		// Search available flights from JFK to LAX
		FlightSearchService flightSearcher = new FlightSearchService(flights);
		List<Flight> availableFlights = flightSearcher.searchFlights("DEL", "BOM");
		System.out.println("Available Flights from DEL to BOM:");
		availableFlights.stream()
				.forEach(flight -> System.out.println(flight.getFlightNumber() + " - Departure: "
						+ flight.getDepartureTime() + ", Arrival: " + flight.getArrivalTime()));

		// Book a ticket for the first available flight
		if (!availableFlights.isEmpty()) {
			Flight firstFlight = availableFlights.get(0);
			Passenger passenger = new Passenger("John Doe", "AB123456");
			BookingService bookingSystem = new BookingService();
			Ticket ticket = bookingSystem.bookTicket(firstFlight, passenger);
			System.out.println("\nTicket Details:");
			ticket.displayTicketDetails();
			
			Passenger passenger2 = new Passenger("Jane Doe", "CD123456");
			Ticket ticket2 = bookingSystem.bookTicket(firstFlight, passenger2);
			System.out.println("\nTicket Details:");
			ticket2.displayTicketDetails();
			

			Passenger passenger3 = new Passenger("Susan Doe", "EF123456");
			Ticket ticket3 = bookingSystem.bookTicket(firstFlight, passenger3);
			System.out.println("\nTicket Details:");
			ticket3.displayTicketDetails();
		} else {
			System.out.println("No available flights for booking.");
		}
	}
}
