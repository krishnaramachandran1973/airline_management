package com.wipro.service;

import com.wipro.exceptions.BookingException;
import com.wipro.model.Flight;
import com.wipro.model.Passenger;
import com.wipro.model.Ticket;

public class BookingService {
	public Ticket bookTicket(Flight flight, Passenger passenger) {
		if (flight.checkAvailability()) {
			flight.decrementAvailableSeats();
			return new Ticket(flight, passenger);
		}
		throw new BookingException("Please check seat availability");
	}
}
