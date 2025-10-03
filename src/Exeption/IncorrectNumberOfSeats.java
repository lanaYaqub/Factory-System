package Exeption;

import model.VehicleTransportation;

public class IncorrectNumberOfSeats extends Exception {
	public IncorrectNumberOfSeats(VehicleTransportation v) {
		super("The number of seats in car / hybrid car can be a maximum of 7 The vehicle <"+ v.getLicensePlate() +"> not added to the system");
	}

}
