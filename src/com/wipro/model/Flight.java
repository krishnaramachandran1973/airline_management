package com.wipro.model;

public abstract class Flight {
	private String flightNumber;
	private String departureAirport;
	private String destinationAirport;
	private String departureTime;
	private String arrivalTime;
	private Fare fare;

	public Flight(String flightNumber, String departureAirport, String destinationAirport, String departureTime,
			String arrivalTime, Fare fare) {
		this.flightNumber = flightNumber;
		this.departureAirport = departureAirport;
		this.destinationAirport = destinationAirport;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.fare = fare;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}
	
	public Fare getFare() {
		return fare;
	}

	public abstract boolean checkAvailability();

	// Method to decrement available seats
	public void decrementAvailableSeats() {
		// Assuming the seat count cannot go below 0
		if (checkAvailability()) {
			if (this instanceof DomesticFlight dfl) {
				dfl.setAvailableSeats(dfl.getAvailableSeats() - 1);
			} else if (this instanceof InternationalFlight ifl) {
				ifl.setAvailableSeats(ifl.getAvailableSeats() - 1);
			}
		}
	}

}
