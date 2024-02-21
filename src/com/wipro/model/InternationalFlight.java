package com.wipro.model;

public class InternationalFlight extends Flight {
	private int availableSeats;

	public InternationalFlight(String flightNumber, String departureAirport, String destinationAirport,
			String departureTime, String arrivalTime, Fare fare, int availableSeats) {
		super(flightNumber, departureAirport, destinationAirport, departureTime, arrivalTime, fare);
		this.availableSeats = availableSeats;
	}

	@Override
	public boolean checkAvailability() {
		return availableSeats > 0;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	

}
